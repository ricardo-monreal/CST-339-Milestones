package com.gcu.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.UserRepository;
import com.gcu.model.LoginModel;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	
	
	@GetMapping("")
	public String display(Model model) 
	{
		// Display login form view 
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		return "login";
		
	}
	
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		System.out.println(String.format("Form with username of %s and password of %s ", loginModel.getUsername(), loginModel.getPassword()));
		
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
	
//		//create some orders
////		ArrayList<ProductModel> products = new ArrayList<ProductModel>();
////		//List<OrderModel> orders = new ArrayList<OrderModel>();
////		products.add(new ProductModel(0L, "00000001", "Product 1", 1.00f, 1));
////		products.add(new ProductModel(1L, "00000002", "Product 2", 2.00f, 1));
////		products.add(new ProductModel(2L, "00000003", "Product 3", 3.00f, 1));
////		products.add(new ProductModel(3L, "00000004", "Product 4", 4.00f, 1));
////		products.add(new ProductModel(4L, "00000005", "Product 5", 5.00f, 1));
//		
//		
//		
	// display the Orders view
		model.addAttribute("title", "Products");
		
	return "products";
	}
	
	


	
	
	
	
	

}
