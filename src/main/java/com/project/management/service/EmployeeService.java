package com.project.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.dao.EmployeeDao;
import com.project.management.pojo.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao userDao;
		
	public Employee findByUsername (String username)
	{
		return userDao.findUserByUsername(username);
	}
	

}
