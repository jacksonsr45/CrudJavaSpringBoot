package com.jacksonsr45.crud.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacksonsr45.crud.controller.dto.UserRequest;
import com.jacksonsr45.crud.domain.model.UserModel;
import com.jacksonsr45.crud.domain.repository.UserRepository;

import static java.util.Objects.isNull;

@Service
public class UserServicesImpl implements UserServices {

	private final UserRepository userRepository;
	
	
	public UserServicesImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public  List<UserModel> findAll() {
		List<UserModel> user = this.userRepository.findAll();
		if(isNull(user)) {
			throw new RuntimeException("User not found!");
		}
		return user;
	}
	
	
	@Override
	public UserModel getOne(Long id) {
		UserModel user = this.userRepository.getOne(id);
		if(isNull(user)) {
			throw new RuntimeException("User not found!");
		}
		return user;
	}
	
	
	@Override
	public void insert(UserRequest user) {
		Date date = new Date();
		var u = new UserModel();
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setCreated_at(date);
		this.userRepository.save(u);
	}
	
	@Override
	public void update(UserRequest user) {
		var u = new UserModel();
		u.setId(user.getId());
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		this.userRepository.save(u);
	}
	
	@Override
	public void delete(Long id) {
		UserModel user = this.userRepository.getOne(id);
		this.userRepository.delete(user);
	}
}
