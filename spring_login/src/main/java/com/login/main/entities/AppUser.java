package com.login.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "username", length = 36, nullable = false, unique = true)
	private String userName;
	
	@Column(name = "password", length = 128, nullable = false)
	private String password;
	
	@Column(name = "enabled", length = 1, nullable = false)
	private boolean enabled;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
