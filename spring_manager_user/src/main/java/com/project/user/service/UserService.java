package com.project.user.service;

import java.util.List;

import com.project.user.entity.User;

public interface UserService {
	List<User> findAll();
	
	User search(String name);
	
	User findById(Long id);
	
	boolean save(User user);
	
	boolean delete(Long id);
}
