package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.user.entity.User;
import com.project.user.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/user")
	public List<User> getUser() {
		return userServiceImpl.findAll();
	}
	
	@PostMapping("/user")
	public String addUser(@RequestBody User user) {
		try {
			userServiceImpl.save(user);
			return "200";
		} catch (Exception e) {
			return "400";
		}
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userServiceImpl.findById(id);
	}
	
	@GetMapping("/user/name")
	public List<User> getUserById(@RequestBody User user) {
		return userServiceImpl.search(user.getName());
	}
}
