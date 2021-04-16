package com.example.loginapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "username", nullable = false, unique = true, length = 64)
	private String username;

	@Column(name = "password", nullable = false, length = 128)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "email", nullable = false, length = 128)
	private String email;

	@Column(name = "verification_code", length = 64, unique = true)
	private String verificationCode;

	public UserEntity() {
	}

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}
