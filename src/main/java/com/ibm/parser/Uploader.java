package com.ibm.parser;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.ibm.employee.bo.impl.EmployeeBoImpl;
import com.ibm.employee.model.Employee;
import com.ibm.week.bo.impl.WeekBoImpl;
import com.ibm.week.model.Week;
import com.ibm.work.bo.impl.WorkBoImpl;

public class Uploader {
	private Set<Week> weeks = new HashSet();
	private WeekBoImpl weekbo = new WeekBoImpl();
	private EmployeeBoImpl emplobo = new EmployeeBoImpl();
	private WorkBoImpl workbo = new WorkBoImpl();
	
	


	public Uploader(Set<Week> weeks, WeekBoImpl weekbo, EmployeeBoImpl emplobo,
			WorkBoImpl workbo) {
		super();
		this.weeks = weeks;
		this.weekbo = weekbo;
		this.emplobo = emplobo;
		this.workbo = workbo;
	}




	public void weekReader(XSSFRow row){
		Week week = new Week();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		XSSFCell cell;
		String aux;
		Date date;
		for(int i=105; i<row.getLastCellNum(); i++) 
			{ //105 o 106 empiezan las semanas
				
				cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
				aux = cell.getStringCellValue();
				try {
					date = (Date) formatter.parse(aux);
					week.setEndDate(date); // sql o utiL?
					Calendar cal = Calendar.getInstance();
					cal.setTime(cell.getDateCellValue());
					week.setNumWeek(cal.get(Calendar.WEEK_OF_YEAR)); 
					weeks.add(week);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}	
	}
	public Employee employeeReader(XSSFRow row){
		Employee employee = new Employee();
		XSSFCell cell;
		cell = row.getCell(1,Row.CREATE_NULL_AS_BLANK);
		employee.setName(cell.getStringCellValue());
		cell = row.getCell(64,row.CREATE_NULL_AS_BLANK);
		employee.setId(cell.getStringCellValue());
		emplobo.save(employee);
		return employee;
	}
	public void workReader(XSSFRow row){
		Employee employee = employeeReader(row);
		
	}
}
