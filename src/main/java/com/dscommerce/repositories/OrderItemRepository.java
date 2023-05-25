package com.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
