package com.gcu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.User;



@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${spring.application.name}")
	String Milestone2;
	
	@GetMapping("/")
	public String indexPage(Model model) 
	{
		// Display login form view
		model.addAttribute("title", "CST-339 Milestone Store");
		model.addAttribute("Milestone2", Milestone2);
		
		
		return "index";
		
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
	
	

}
