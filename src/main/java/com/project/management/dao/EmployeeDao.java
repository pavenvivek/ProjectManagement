package com.project.management.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.management.pojo.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Employee findByUsernameAndPassword (String username, String password)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from Employee where username = :p1 and password = :p2 and deleteFlag = :p3");
			query.setParameter("p1", username);
			query.setParameter("p2", password);
			query.setParameter("p3", "N");
			
			Employee emp = (Employee) query.uniqueResult();
			
			return emp;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}

	public Employee findUserByUsername(String username) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Query query = session.createQuery("from Employee where username = :p1");
			query.setParameter("p1", username);
			
			Employee emp = (Employee) query.uniqueResult();
			
			return emp;
			
		}catch(Exception e){
			System.out.println("\n\nError in findUserByUsername !\n\n");
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}

	public Employee findById(Integer id) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			
			Employee emp = (Employee) session.get(Employee.class, id);
			
			return emp;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}

}
