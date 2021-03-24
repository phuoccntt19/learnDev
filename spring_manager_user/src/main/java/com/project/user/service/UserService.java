package com.project.user.service;

import java.util.List;

import com.project.user.entity.User;

public interface UserService {
	List<User> findAll();
	
	List<User> search(String name);
	
	User findById(Long id);
	
	void save(User user);
	
	void delete(Long id);
}
