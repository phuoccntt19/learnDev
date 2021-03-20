package com.phuocvt.entity;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UserRepository extends JpaRepository<AppUser, Long> {
	@Query("SELECT u FROM AppUser u WHERE u.userName = ?1")
	AppUser findByUsername(String username);

	@Query("SELECT userId FROM AppUser")
	ArrayList<Long> findMaxId();
	
	@Query("SELECT id FROM UserRole")
	ArrayList<Long> findMaxIdUserRole();
	
	@Modifying
	@Query(
	  value = 
	    "INSERT INTO app_user(USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) VALUES (?1, ?2, ?3, ?4);",
	  nativeQuery = true)
	void insertUser(Long USER_ID, String USER_NAME, String ENCRYTED_PASSWORD, Integer ENABLED);
	
	@Modifying
	@Query(
	  value = 
	    "INSERT INTO user_role (ID, USER_ID, ROLE_ID) VALUES (?1, ?2, 2);",
	  nativeQuery = true)
	void insertUserRole(Long ID, Long USER_ID);
}
