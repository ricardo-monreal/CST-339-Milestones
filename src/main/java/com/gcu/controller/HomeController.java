package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.ProductRepository;
import com.gcu.UserRepository;
import com.gcu.model.ProductModel;
import com.gcu.model.User;
import com.gcu.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${spring.application.name}")
	String Milestone2;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	// handle requests from the service class
	@Autowired ProductService service;
	
	// home page handler
	@GetMapping("/")
	public String indexPage(Model model) 
	{
		// Display login form view
		model.addAttribute("title", "CST-339 Milestone Store");
		model.addAttribute("Milestone2", Milestone2);
		
		
		return "index";
		
	}
	
	
	// register handler
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
	
	// register success handler
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
	
	// create product handler
	@GetMapping("/create-product")
	public String createProductForm(Model model) {
		model.addAttribute("product", new ProductModel());
		
		return "create_product";
	}
	
	
	// products handler // displays products after login in
	@GetMapping("/products")
	public String listProducts(Model model) {
		List<ProductModel> listProducts = productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		return "products";
	}
	
	// product create product handler
	@PostMapping("/process_create_product")
	public String processCreateProduct(ProductModel product) {
		productRepo.save(product);
		
		return "product_create_success";
	}
	
	// edit product handler
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		
		ModelAndView mav = new ModelAndView("edit_product");
		
		// testing
		ProductModel product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	
	// save product handler ==== TESTING
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") ProductModel product) {
		service.save(product);
		
		return "product_create_success";
	}
	
	// update product handler ==== TESTING
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") ProductModel product) {
		service.save(product);
			
		return "product_update_success";
	}
	
	// implement delete product feature === Milestone 5
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/products";
	}
	
	

}
