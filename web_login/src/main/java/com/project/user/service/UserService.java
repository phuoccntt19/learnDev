package com.project.user.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import com.project.user.entity.User;

public interface UserService {
	List<User> findAll();
	
	User search(String name);
	
	boolean save(User user, String siteURL) throws UnsupportedEncodingException, MessagingException;
	
	boolean delete(Long id);
	
	void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
