package net.haaim.web.api.common;

import lombok.Getter;

@Getter
public enum Role {
	//4:관리자/3:원장/2:교사/1:코디/0:학생
	STUDENT(0, "학생"),	
	CODY(1, "코디"),	
	TEACHER(2, "교사"),
	OWNER(3, "원장"),
	MANAGER(4, "관리자");
	
	private int code = 0;
	private String remark = "";
	
	Role(int code, String remark) {
		this.code = code;
		this.remark = remark;
	}
	
	public static Role getRole(int type) {
		for(Role role : Role.values()) {
			if(type == role.getCode()) {
				return role;
			}
		}
		return null;
	}
}
