package com.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.user.dao.UserRepository;
import com.project.user.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User search(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean save(User user) {
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setActive(false);
		BCryptPasswordEncoder bPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bPasswordEncoder.encode(user.getPassword()));
		if(userRepository.findByUsername(user.getUsername()) == null) {
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
