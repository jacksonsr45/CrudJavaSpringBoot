package com.jacksonsr45.crud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jacksonsr45.crud.controller.dto.UserRequest;
import com.jacksonsr45.crud.controller.dto.UserResponse;
import com.jacksonsr45.crud.services.UserServicesImpl;


@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserServicesImpl userServiceImpl;
	
	public UserController(UserServicesImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping("/")
	public List<UserResponse> findall() {
		var users = this.userServiceImpl.findAll();
		return users.stream()
				.map(UserResponse::converter)
				.collect(Collectors.toList());
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public UserResponse findById(@PathVariable("id") Long id) {
		var user = this.userServiceImpl.getOne(id);
		return UserResponse.converter(user);
	}
	
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void insert(@RequestBody UserRequest user) {
		this.userServiceImpl.insert(user);
	}
	
	
	@PutMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody UserRequest user) {
		this.userServiceImpl.update(user);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		this.userServiceImpl.delete(id);
	}
}
