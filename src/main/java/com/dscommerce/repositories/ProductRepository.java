package com.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
