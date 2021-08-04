package com.gcu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>
{

}
