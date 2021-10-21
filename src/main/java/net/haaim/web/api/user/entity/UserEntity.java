package net.haaim.web.api.user.entity;

import lombok.Data;

@Data
public class UserEntity {
	private String userName;
	private String password;
	private Integer uType;
	private Integer studentNo;
}
