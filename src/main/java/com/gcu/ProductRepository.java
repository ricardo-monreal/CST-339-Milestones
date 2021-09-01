package com.gcu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gcu.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>
{
	//milestone 7
	List<ProductModel> findAllProductById(@Param("id")Long id);
	

}
