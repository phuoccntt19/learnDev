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
	
	private boolean principal = false;
	
	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("principal", principal);
		
		model.addAttribute("listUser", userServiceImpl.findAll());
		return "home";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("principal", principal);
		
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerProcessing(Model model, UserEntity user) {
		model.addAttribute("principal", principal);
		
		UserEntity userEntity = userServiceImpl.register(user);
		if(userEntity != null) {
			return "redirect:/register?error=true";
		} else {
			return "redirect:/register?error=false";
		}
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("principal", principal);
		
		UserEntity userEntity = new UserEntity();
		model.addAttribute("user", userEntity);
		return "login";
	}
	
	@PostMapping("/login")
	public String loginProcessing(Model model, UserEntity user) {
		model.addAttribute("principal", principal);
		
		if(userServiceImpl.login(user)) {
			this.principal = true;
			model.addAttribute("principal", principal);
			model.addAttribute("listUser", userServiceImpl.findAll());
			return "home";
		} else {
			return "redirect:/login?error=true";
		}
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		this.principal = false;
		
		model.addAttribute("principal", principal);
		return "home";
	}
}
