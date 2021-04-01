package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("principal", false);
		model.addAttribute("listUser", userServiceImpl.findAll());
		return "home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerProccess(Model model, UserEntity user) {
		UserEntity userEntity = userServiceImpl.register(user);
		if(userEntity != null) {
			return "redirect:/register?error=true";
		} else {
			return "redirect:/register?error=false";
		}
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, UserEntity user) {
		if(userServiceImpl.login(user)) {
			model.addAttribute("principal", true);
			model.addAttribute("listUser", userServiceImpl.findAll());
			return "home";
		} else {
			return "redirect:/login?error=true";
		}
	}
}
