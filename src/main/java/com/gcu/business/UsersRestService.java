package com.gcu.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.controller.CustomUserDetailsService;
import com.gcu.model.User;
import com.gcu.model.UserList;
import com.gcu.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UsersRestService {
	
	@Autowired
	private UserService service;
	
	
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsersAsJson()
	{
		return service.getUsers();
	}
	
	
	@RequestMapping(path="/getxml", produces = { MediaType.APPLICATION_XML_VALUE } )
	public UserList getUsersAsXml()
	{
		UserList list = new UserList();
		list.setUsers(service.getUsers());
		return list;
	}

}
