package com.login.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.main.dao.UserRepository;
import com.login.main.entity.UserEntity;

@Service
public class UserServiceIplm implements UserSevice {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserEntity saveUser(UserEntity user) {
		return repo.save(user);
	}

}
