package com.project.management.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.management.pojo.Employee;
import com.project.management.pojo.Project;
import com.project.management.pojo.Team;
import com.project.management.service.EmployeeService;
import com.project.management.service.LoginService;

@Controller
public class EmployeeController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private EmployeeService empService;
	
	
	
	@RequestMapping(value="employeeMng.html")
	public String goToUserMngScreen(Model model,HttpSession session){
		
		String username = (String) session.getAttribute("username");
		Project project = loginService.retrieveForManager(username);
		model.addAttribute("projectManaged", project);
		
		Team team = loginService.retrieveForTeamLead(username);		
		model.addAttribute("teamManaged", team);
		
		Employee emp = empService.findByUsername(username);
		model.addAttribute("empDetails", emp);
		
		return "employeeMng.jsp";
	}
	
}
