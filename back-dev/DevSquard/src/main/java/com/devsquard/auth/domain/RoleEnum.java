package com.devsquard.auth.domain;

public enum RoleEnum {
	ROLE_USER("ROLE_USER"),
	ROLE_MEMBER("ROLE_MEMBER"),
	ROLE_OWNER("ROLE_OWNER"),
	ROLE_ADMIN("ROLE_ADMIN");
	
	String role;
	
	RoleEnum(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
