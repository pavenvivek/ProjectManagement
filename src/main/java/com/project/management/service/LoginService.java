package com.project.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.dao.CommentsDao;
import com.project.management.dao.EmployeeDao;
import com.project.management.dao.ProjectDao;
import com.project.management.dao.TasksDao;
import com.project.management.dao.TeamDao;
import com.project.management.pojo.Comments;
import com.project.management.pojo.Employee;
import com.project.management.pojo.Project;
import com.project.management.pojo.Tasks;
import com.project.management.pojo.Team;

@Service
public class LoginService {

	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private TasksDao taskDao;
	@Autowired
	private CommentsDao cmtDao;
	
	public Boolean isValidUser(String username,String password){
		
		Employee emp = empDao.findByUsernameAndPassword(username, password);

		if(emp == null){
			return false;
		}else{
			return true;
		}		
	}

	public Project retrieveForManager(String username) {
		
		Employee manager = empDao.findUserByUsername(username);
		
		Project proj = projectDao.findProjectByManagerId(manager.getId());
		
		return proj;
	}

	public Team retrieveForTeamLead(String username) {
		
		Employee teamLead = empDao.findUserByUsername(username);
		Team team = teamDao.findTeamByTeamLeadId(teamLead.getId());
		
		return team;
	}
	
	public Employee retrieveEmployee(String username){
		return empDao.findUserByUsername(username);
	}
	
	public List<Tasks> retrieveTasks(){
		return taskDao.getAllTasks();
	}

	public List<Comments> retrieveReceivedMsgs(Integer msg_to){
		return cmtDao.getMsgByRecvId(msg_to);
	}
	
	public List<Comments> retrieveSendMsgs(Integer msg_to){
		return cmtDao.getMsgByRecvId(msg_to);
	}

}
