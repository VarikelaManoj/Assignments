package com.company.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.model.Task;
@Transactional
@Repository
public class TaskDaoImpl implements TaskDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addTask(Task task) {
		sessionFactory.getCurrentSession().save(task);
	}

	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(task);
	}

	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Task task=(Task)session.get(Task.class, new Integer(id));
			session.delete(task);	
		
	}

	
	public List<Task> viewFinishedTasks(String postedBy) {
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Task.class);
		ct.add(Restrictions.eq("postedBy",postedBy));
		ct.add(Restrictions.eq("status",true));
		List<Task> list=ct.list();
		System.out.println(list);// TODO Auto-generated method stub
		return list;
	}

	public List<Task> viewClientTasks(String postedBy) {
		Session session=sessionFactory.getCurrentSession();
		Criteria ct=session.createCriteria(Task.class);
		ct.add(Restrictions.eq("postedBy",postedBy));
		ct.add(Restrictions.eq("status",false));
		List<Task> list=ct.list();
		System.out.println(list);// TODO Auto-generated method stub
		return list;
	}

}
