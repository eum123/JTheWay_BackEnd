package net.haaim.web.common;

import lombok.Getter;

@Getter
public class User {
	private String id;
	private Role role;
	
	public User(String id, Role role) {
		this.id = id;
		this.role = role;
	}
}
