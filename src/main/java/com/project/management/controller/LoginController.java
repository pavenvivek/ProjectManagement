package com.project.management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.management.pojo.Comments;
import com.project.management.pojo.Employee;
import com.project.management.pojo.Project;
import com.project.management.pojo.Tasks;
import com.project.management.pojo.Team;
import com.project.management.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login.html",method = RequestMethod.GET)
	public String goToLoginPage(){
		return "login.jsp";
	}
	
	
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST )
	public String validateUser(Model model,HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password){

		Boolean status = loginService.isValidUser(username, password);
		
		if(status) {
			
			session.setAttribute("username", username);
						
			session.setAttribute("isLoggedIn", "yes");		

			Project proj = loginService.retrieveForManager(username);
			
			if (null != proj){
				model.addAttribute("projectManaged", proj);				
			}
			
			Team team = loginService.retrieveForTeamLead(username);
			
			if (null != team){
				model.addAttribute("teamManaged", team);
			}
			
			List<Tasks> tasks = loginService.retrieveTasks();
			
			if (null != tasks){
			
				model.addAttribute("tasks", tasks);
			}
			
			Employee emp = loginService.retrieveEmployee(username);
			List<Comments> rcv_msgs = loginService.retrieveReceivedMsgs(emp.getId());

			if (null != rcv_msgs){
				
				model.addAttribute("received_msgs", rcv_msgs);
			}

			List<Comments> send_msgs = loginService.retrieveSendMsgs(emp.getId());

			if (null != send_msgs){
				
				model.addAttribute("send_msgs", send_msgs);
			}

			return "dashboard.jsp";

		}else {
			
			//System.out.println("\n\nUser Not Found !\n\n");
			return "login.jsp";
		}
	}
	
	
	@RequestMapping(value="logout.html")
	public String logout(Model model,HttpSession session){
		
		session.invalidate();
			
		return "login.jsp";
	}
	
}
