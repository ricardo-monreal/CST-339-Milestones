package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.ProductRepository;
import com.gcu.UserRepository;
import com.gcu.model.ProductModel;
import com.gcu.model.User;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${spring.application.name}")
	String Milestone2;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
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
	
	
	@PostMapping("/process_register")
	public String processRegister(User user)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	
	// FindAll is defined by the Spring Data JPA’s JpaRepository interface.
	@GetMapping("/users")
	public String listUsers(Model model) {
	    List<User> listUsers = userRepo.findAll();
	    model.addAttribute("listUsers", listUsers);
	     
	    return "users";
	}
	
	@GetMapping("/create-product")
	public String createProductForm(Model model) {
		model.addAttribute("product", new ProductModel());
		
		return "create_product";
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<ProductModel> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		return "products";
	}
	
	@PostMapping("process_create_product")
	public String processCreateProduct(ProductModel product) {
		productRepo.save(product);
		
		return "product_create_success";
	}
	
	

}
