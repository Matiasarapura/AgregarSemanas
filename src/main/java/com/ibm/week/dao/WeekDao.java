package com.ibm.week.dao;

import org.springframework.transaction.annotation.Transactional;

import com.ibm.week.model.Week;

public interface WeekDao {

	void save(Week week);
	
	void update(Week week);
	
	void delete(Week week);
	
	Week findById(int id);
}
