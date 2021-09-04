package com.gcu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.gcu.model.ProductModel;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductRepository productRepo;

	
	
	
	@Test
	public void testCreateProduct() {
		
		ProductModel product = new ProductModel();
		product.setProductNo("0");
		product.setProductName("Jordan 1");
		product.setPrice(99.99F);
		product.setQuantity(1);
		
		ProductModel savedProduct = productRepo.save(product);
		
		ProductModel existProduct = entityManager.find(ProductModel.class, savedProduct.getId());
		
		assertThat(product.getProductName()).isEqualTo(existProduct.getProductName());
	}
	
	

	
}
