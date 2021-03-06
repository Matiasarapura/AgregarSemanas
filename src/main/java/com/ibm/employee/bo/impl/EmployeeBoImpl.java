package com.ibm.employee.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.employee.bo.EmployeeBo;
import com.ibm.employee.dao.EmployeeDao;
import com.ibm.employee.model.Employee;

@Service("employeeBo")
public class EmployeeBoImpl implements EmployeeBo{
	
	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void save(Employee employee){
		employeeDao.save(employee);
	}
	
	public void update(Employee employee){
		employeeDao.update(employee);
	}
	
	public void delete(Employee employee){
		employeeDao.delete(employee);
	}
	
	public Employee findById(String id){
		return employeeDao.findById(id);
	}
	
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
}