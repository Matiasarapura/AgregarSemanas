package com.ibm.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.employee.bo.EmployeeBo;
import com.ibm.employee.model.Employee;
import com.ibm.week.bo.WeekBo;
import com.ibm.week.model.Week;
import com.ibm.work.bo.WorkBo;
import com.ibm.work.model.Work;


public class AppTest 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	EmployeeBo employeeBo = (EmployeeBo)appContext.getBean("employeeBo");
    	Employee emp1 = employeeBo.findById("08773A");
    	System.out.println(emp1.toString());
    			
    	WeekBo weekBo = (WeekBo)appContext.getBean("weekBo");
    	Week week1 = weekBo.findById(2);
    	test.uploadDate(weekBo);
    	System.out.println(week1.toString());
    	
    	WorkBo workBo = (WorkBo)appContext.getBean("workBo");
    	Work work1 = new Work(emp1,week1,69,8);
    	workBo.save(work1);
    	
    	System.out.println(workBo.findAll());
    }
}