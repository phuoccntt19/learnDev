package com.example.loginapi.controller;

import com.example.loginapi.entity.UserEntity;
import com.example.loginapi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/")
    public String hello() {
        return "hello";
    }

    @PostMapping(value = "/register")
    public boolean register(@RequestBody UserEntity userEntity) {
        return userServiceImpl.register(userEntity);
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userServiceImpl.verify(code)) {
            return "successfully";
        } else {
            return "fail";
        }
    }
}
