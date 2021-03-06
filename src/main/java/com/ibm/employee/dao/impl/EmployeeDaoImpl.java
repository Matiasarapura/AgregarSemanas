package com.ibm.employee.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.employee.dao.EmployeeDao;
import com.ibm.employee.model.Employee;
import com.ibm.util.CustomHibernateDaoSupport;


@Repository("EmployeeDao")
public class EmployeeDaoImpl  extends CustomHibernateDaoSupport implements EmployeeDao{

	public void save(Employee employee){
		getHibernateTemplate().saveOrUpdate(employee);
	}
	
	public void update(Employee employee){
		getHibernateTemplate().update(employee);
	}
	
	public void delete(Employee employee){
		getHibernateTemplate().delete(employee);
	}
	
	@Transactional
	public Employee findById(String id){
		Employee e1 = (Employee) getSessionFactory().getCurrentSession().get(Employee.class, id);
		return e1;
	}
	
	@Transactional
	public List<Employee> findAll(){
		List<Employee> employeeList = getSessionFactory().getCurrentSession().createCriteria(Employee.class).list();
		return employeeList;
	}
	
}
