package com.login.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="username", nullable=false, unique=true, length=64)
	private String username;
	
	@Column(name="password", nullable=false, length=128)
	private String password;
	
	@Column(name="role", nullable=false, length=64)
	private String role;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}
	
	
}
