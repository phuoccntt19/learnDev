package com.example.loginapi.service;

import com.example.loginapi.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public interface UserService {
    boolean register(UserEntity userEntity);
    void sendVerificationEmail(UserEntity user) throws MessagingException, UnsupportedEncodingException;
}
