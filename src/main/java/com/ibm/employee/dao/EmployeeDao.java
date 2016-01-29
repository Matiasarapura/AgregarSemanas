package com.ibm.employee.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.ibm.employee.model.Employee;

public interface EmployeeDao {
	
	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete(Employee employee);
	
	Employee findById(String id);
	
	List<Employee> findAll();
}
