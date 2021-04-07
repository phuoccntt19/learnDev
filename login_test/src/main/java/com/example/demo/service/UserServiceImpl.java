package com.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;
import com.google.common.hash.Hashing;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserEntity register(UserEntity userEntity) {
		
		String sha256Password = Hashing.sha256().hashString(userEntity.getPassword(), StandardCharsets.UTF_8).toString();
		
		userEntity.setRole("user");
		userEntity.setEnabled(true);
		userEntity.setPassword(sha256Password);
		
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
		UserEntity userTemp = findByUsername(userEntity.getUsername());
		String sha256Password = Hashing.sha256().hashString(userEntity.getPassword(), StandardCharsets.UTF_8).toString();
		if(userTemp == null) {
			return false;
		} else {
			if(sha256Password.equals(userTemp.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
