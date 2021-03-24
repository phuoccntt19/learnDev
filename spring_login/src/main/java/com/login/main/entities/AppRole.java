package com.login.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_role")
public class AppRole {
	
	@Id
	@GeneratedValue
	@Column(name = "role_id", nullable = false)
	private int roleId;
	
	@Column(name = "role_name", nullable = false, length = 32)
	private int roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}
	
}
