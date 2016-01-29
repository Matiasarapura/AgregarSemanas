package com.ibm.week.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.util.CustomHibernateDaoSupport;
import com.ibm.week.dao.WeekDao;
import com.ibm.week.model.Week;

@Repository("weekDao")
public class WeekDaoImpl extends CustomHibernateDaoSupport implements WeekDao{
	
	public void save(Week week){
		getHibernateTemplate().save(week);
	}
	
	public void update(Week week){
		getHibernateTemplate().update(week);
	}
	
	public void delete(Week week){
		getHibernateTemplate().delete(week);
	}
	@Transactional
	public Week findById(int id){
		Week w1 = (Week) getSessionFactory().getCurrentSession().get(Week.class, id);
		return w1;
	}
}
