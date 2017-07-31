package com.project.management.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.management.pojo.Employee;
import com.project.management.pojo.Project;

@Repository
public class ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Project findProjectById(Integer id) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Project prj = (Project) session.get(Project.class, id);
			
			return prj;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}
	
	public Project findProjectByManagerId(Integer managerId) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();

			Query query = session.createQuery("from Project where projectManager = :p1");
			query.setParameter("p1", managerId);
			
			Project prj = (Project) query.uniqueResult();
			
			return prj;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}


}
