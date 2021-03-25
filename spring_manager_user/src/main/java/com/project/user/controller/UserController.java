package com.project.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.user.entity.User;
import com.project.user.service.UserServiceImpl;

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
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		BCryptPasswordEncoder bPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bPasswordEncoder.encode(user.getPassword()));
		if(userServiceImpl.save(user)) {
			model.addAttribute("message", "Successful registration!");
		} else {
			model.addAttribute("message", "Registration was not successful!");
		}
		
		return "welcomePage";
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
}
