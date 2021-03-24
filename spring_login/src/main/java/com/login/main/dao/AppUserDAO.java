package com.login.main.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.main.entities.AppUser;

@Repository
public class AppUserDAO {

	@Autowired
	private EntityManager entityManager;
	
	public AppUser findUserAccount(String username) {
		try {
			String sql = "select e from " + AppUser.class.getName() + " e "
						+"where e.userName = :username ";
			
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("username", username);
			
			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}