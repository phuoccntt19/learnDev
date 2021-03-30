package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.user.entity.User;
import com.project.user.service.UserServiceImpl;
import com.sun.security.auth.UserPrincipal;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		
		model.addAttribute("message", "Hello!");
		
		return "welcomePage";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		
		return "registerPage";
	}
	
	@PostMapping("/register")
	public String registerUser(Model model, @ModelAttribute("user") User user) {
		if(userServiceImpl.save(user)) {
			model.addAttribute("message", "Successful registration!");
		} else {
			model.addAttribute("message", "User already exists!!!");
		}
		return "registerPage";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "loginPage";
	}
	
	@GetMapping("/logoutSuccessful")
	public String logoutPage(Model model) {
		model.addAttribute("message", "Log out successful!");
		return "loginPage";
	}
	
	@GetMapping("/user")
	public String userPage(Model model) {
		model.addAttribute("message", "USER");
		return "userPage";
	}
	
	@GetMapping("/admin")
	public String adminPage(Model model) {
		List<User> users = userServiceImpl.findAll();
		model.addAttribute("users", users);
		model.addAttribute("message", "ADMIN");
		return "adminPage";
	}
	
	@GetMapping("/403")
	public String page403(Model model) {
		model.addAttribute("message", "Unauthorized");
		return "403Page";
	}
}
