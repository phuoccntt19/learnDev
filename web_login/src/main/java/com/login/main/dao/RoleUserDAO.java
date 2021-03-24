package com.login.main.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleUserDAO {
	
	@Autowired
    private EntityManager entityManager;
	
	@Transactional
	public void insertRoleUser(int userId) {
	    entityManager.createNativeQuery("INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES (?, 2)")
	      .setParameter(1, userId)
	      .executeUpdate();
	}
}
