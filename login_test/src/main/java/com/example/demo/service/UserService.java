package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserService {
	UserEntity register(UserEntity userEntity);
	
	List<UserEntity> findAll();
	
	UserEntity findByUsername(String username);
	
	boolean login(UserEntity userEntity);
}
