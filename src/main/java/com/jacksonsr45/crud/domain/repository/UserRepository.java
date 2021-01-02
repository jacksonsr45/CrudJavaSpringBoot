package com.jacksonsr45.crud.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksonsr45.crud.domain.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>  {

}
