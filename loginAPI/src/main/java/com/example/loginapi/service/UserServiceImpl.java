package com.example.loginapi.service;

import com.example.loginapi.entity.UserEntity;
import com.example.loginapi.repository.UserRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean register(UserEntity userEntity) {

        userEntity.setEnabled(false);

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        userEntity.setPassword(bCrypt.encode(userEntity.getPassword()));

        String randomCode = RandomString.make(64);
        userEntity.setVerificationCode(randomCode);

        try {
            userRepository.save(userEntity);
            sendVerificationEmail(userEntity);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void sendVerificationEmail(UserEntity user) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "phuoccntt19@gmail.com";
        String senderName = "Viet Phuoc";
        String subject = "Please verify your registration";
        String content = "Dear [[email]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Viet Phuoc.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[email]]", user.getEmail());
        String verifyURL = "http://localhost:8080/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    public boolean verify(String verificationCode) {
        UserEntity userEntity = userRepository.findByVerificationCode(verificationCode);

        if (userEntity == null || userEntity.isEnabled()) {
            return false;
        } else {
            userEntity.setVerificationCode(null);
            userEntity.setEnabled(true);
            userRepository.save(userEntity);
            return true;
        }

    }
}
