package com.ibm.common;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.week.bo.WeekBo;
import com.ibm.week.bo.impl.WeekBoImpl;
import com.ibm.week.model.Week;


public class test {
	public static void uploadDate(WeekBo wbo) {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
			Calendar startDate = Calendar.getInstance();
			Calendar endDate = Calendar.getInstance();
			startDate.setTime(sf.parse("01 jan 2016"));
			endDate.setTime(sf.parse("01 jan 2018"));
			Date date = null;
			Week week = new Week();
			
			java.sql.Date sqlDate;
			
			while (startDate.before(endDate)) {

				startDate.add(Calendar.WEEK_OF_YEAR, +0);
				startDate.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				date = startDate.getTime();
				sqlDate = new java.sql.Date(date.getTime());
				week.setStartDate(sqlDate);
				week.setNumWeek(startDate.get(Calendar.WEEK_OF_YEAR));
				////
				startDate.add(Calendar.WEEK_OF_YEAR, +1);
				startDate.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
				date = startDate.getTime();
				sqlDate = new java.sql.Date(date.getTime());
				week.setEndDate(sqlDate);
				wbo.save(week);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
