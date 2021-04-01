package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserEntity register(UserEntity userEntity) {
		BCryptPasswordEncoder bCEncoder = new BCryptPasswordEncoder();
		userEntity.setRole("user");
		userEntity.setEnabled(true);
		
		userEntity.setPassword(bCEncoder.encode(userEntity.getPassword()));
		
		try {
			userRepo.save(userEntity);
			return userEntity;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}

	@Override
	public UserEntity findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public boolean login(UserEntity userEntity) {
		BCryptPasswordEncoder bCEncoder = new BCryptPasswordEncoder();
		UserEntity userTemp = findByUsername(userEntity.getUsername());
		if(userTemp == null) {
			return false;
		} else {
			if(bCEncoder.matches(userEntity.getPassword(), userTemp.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
