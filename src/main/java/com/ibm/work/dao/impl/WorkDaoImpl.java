package com.ibm.work.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.util.CustomHibernateDaoSupport;
import com.ibm.work.dao.WorkDao;
import com.ibm.work.model.Work;


@Repository("workDao")
public class WorkDaoImpl extends CustomHibernateDaoSupport implements WorkDao{
	
	public void save(Work work){
		getHibernateTemplate().saveOrUpdate(work);
	}
	
	public void update(Work work){
		getHibernateTemplate().update(work);
	}
	
	public void delete(Work work){
		getHibernateTemplate().delete(work);
	}
	
	@Transactional
	public List<Work> findAll(){
		List<Work> worList = getSessionFactory().getCurrentSession().createCriteria(Work.class).list();
		return worList;
	}

}