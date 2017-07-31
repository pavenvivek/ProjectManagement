package com.project.management.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.management.pojo.Employee;
import com.project.management.pojo.Team;

@Repository
public class TeamDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Team findTeamById(Integer id) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			Team team = (Team) session.get(Team.class, id);
			
			return team;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}
	
	public Team findTeamByTeamLeadId(Integer teamLeadId) {
		Session session = null;
		
		try{
			session = sessionFactory.openSession();

			Query query = session.createQuery("from Team where teamLead = :p1");
			query.setParameter("p1", teamLeadId);
			
			Team team = (Team) query.uniqueResult();
			
			return team;
			
		}catch(Exception e){
			e.printStackTrace();
			
			return null;
			
		}finally {
			session.close();
		}
	}


}
