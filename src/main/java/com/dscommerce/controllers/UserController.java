package com.dscommerce.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dscommerce.entities.User;
import com.dscommerce.entities.dto.UserRequestDTO;
import com.dscommerce.entities.dto.UserResponseDTO;
import com.dscommerce.mapper.UserMapper;
import com.dscommerce.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	UserMapper mapper;

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserResponseDTO> listDTO = list.stream().map(x -> mapper.toUserResponseDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
		User user = service.findById(id);
		UserResponseDTO userDTO = mapper.toUserResponseDTO(user);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO userRequest) {
		User user = mapper.toUserInResquest(userRequest);
		user = service.insert(user);
		UserResponseDTO userResponse = mapper.toUserResponseDTO(user);
		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO userRequest) {
		User user = mapper.toUserInResquest(userRequest);
		user = service.update(id, user);
		UserResponseDTO userResponse = mapper.toUserResponseDTO(user);
		return ResponseEntity.ok().body(userResponse);
	}

}
