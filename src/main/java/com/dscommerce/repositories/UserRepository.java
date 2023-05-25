package com.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dscommerce.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
