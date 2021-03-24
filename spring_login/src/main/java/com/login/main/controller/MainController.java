package com.login.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.main.entities.AppUser;
import com.login.main.service.UserDetailsServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	private UserDetailsServiceImpl userService;

	@RequestMapping(value={"/", "/welcome"}, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		return "loginPage";
	}
	
	@GetMapping("/userAccountInfo")
	public String userAccountInfo(Model model) {
		return "redirect:/userInfo";
	}
}
