package com.gcu.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcu.ProductRepository;
import com.gcu.model.ProductModel;



// class is redundant as it delegates all the calls to ProductRepository.
// we create this class for the purpose of extensibility in future.
@Service
@Transactional 
public class ProductService {
	
	// we inject an instance of ProductRepository via private field using @Autowired annotation.
	@Autowired
	private ProductRepository repo;
	
	
	// create CRUD operations
	public List<ProductModel> listAll() {
		
		return repo.findAll();
	}
	
	public void save(ProductModel product) {
		repo.save(product);
	}
	
	public ProductModel get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	

}
