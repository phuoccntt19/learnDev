package com.example.loginapi.repository;

import com.example.loginapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByVerificationCode(String verificationCode);
    UserEntity findByUsername(String username);
}
