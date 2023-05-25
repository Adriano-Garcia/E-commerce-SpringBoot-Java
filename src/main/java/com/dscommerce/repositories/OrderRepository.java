package com.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
