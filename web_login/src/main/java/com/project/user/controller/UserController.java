package com.project.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.user.entity.User;
import com.project.user.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public String welcomePage(Model model) {
		
		BCryptPasswordEncoder bPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bPasswordEncoder.encode("admin"));
		
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
	public String processRegister(User user, HttpServletRequest request, Model model)
            throws UnsupportedEncodingException, MessagingException {
        if(userServiceImpl.save(user, getSiteURL(request))) {
        	return "registerSuccess";
        } else {
        	model.addAttribute("error", "e");
        	model.addAttribute("message", "Registration failed!!!");
            return "registerPage";
        }
    }
	
	private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
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
	
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code,Model model) {
	    if (userServiceImpl.verify(code)) {
			model.addAttribute("message", "Congratulations, your account has been verified.");
			return "welcomePage";
	    } else {
			model.addAttribute("message", "Sorry, we could not verify account. It maybe already verified, or verification code is incorrect.");
			return "welcomePage";
	    }
	}
}
