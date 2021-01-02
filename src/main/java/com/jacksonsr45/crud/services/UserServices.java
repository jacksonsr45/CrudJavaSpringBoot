package com.jacksonsr45.crud.services;

import java.util.List;

import com.jacksonsr45.crud.controller.dto.UserRequest;
import com.jacksonsr45.crud.domain.model.UserModel;

public interface UserServices {
	List<UserModel> findAll();
	
	UserModel getOne(Long id);
	
	void insert(UserRequest user);
	
	void update(UserRequest user);
	
	void delete(Long id);
}
