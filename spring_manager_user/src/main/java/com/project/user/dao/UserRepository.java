package com.project.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByNameContaining(String name);
}
