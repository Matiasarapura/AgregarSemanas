package com.ibm.work.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ibm.work.model.Work;

public interface WorkDao {
	
	void save(Work work);
	
	void update(Work work);
	
	void delete(Work work);
	
	List<Work> findAll();

}