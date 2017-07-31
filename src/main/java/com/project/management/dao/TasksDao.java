package com.project.management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.management.pojo.Tasks;

@Repository
public class TasksDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Tasks getTaskbyId (Integer id)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Tasks task = (Tasks) session.get(Tasks.class, id);
			
			return task;
			
		}
		catch (Exception exc){
			exc.printStackTrace();
			
			return null;
		}
		finally {
			session.close();
		}
	}
	
	public void createTask (Tasks task)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public List<Tasks> getAllTasks()
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from Tasks");

			return query.list(); //ltsk;
		}
		catch (Exception exc){
			exc.printStackTrace();
			
			return null;
		}
		finally {
			session.close();
		}
	}
}
