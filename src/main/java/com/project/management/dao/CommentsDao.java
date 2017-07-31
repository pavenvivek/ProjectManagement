package com.project.management.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.management.pojo.Comments;

@Repository
public class CommentsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Comments> getMsgByRecvId (Integer msg_to)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Comments where msg_to = :p1");
			query.setParameter("p1", msg_to);
			
			return query.list();
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
			return null;
		}
		finally {
			session.close();
		}
	}

	public List<Comments> getMsgBySendId (Integer msg_from)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Comments where msg_from = :p1");
			query.setParameter("p1", msg_from);
			
			return query.list();
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
			return null;
		}
		finally {
			session.close();
		}
	}

	public void createMsg (Comments cmt)
	{
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(cmt);
			session.getTransaction().commit();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
