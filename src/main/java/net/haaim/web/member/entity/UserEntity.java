package net.haaim.web.member.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.Role;
import net.haaim.web.common.entity.CommonEntity;


@Entity // jpa entity임을 알립니다.
@Table(name = "user")
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends CommonEntity {//implements UserDetails {
	@Id // pk
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_pw")
	private String userPassword;
	
	@Column(name = "user_type")
	private Role userType;
	
	@Column(name = "use_yn")
	private int usage;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "email")
	private String email;
	
	@Builder
	public UserEntity(String userId, String userPassword, int userType
			, int usage, String name, String mobile, String email
			, String inputId, Date inputDate, String updateId, Date updateDate) {
		super(inputId, inputDate, updateId, updateDate);
		
		validate(userId);
		
		this.userId = userId;
		this.userPassword = userPassword;
		this.userType = Role.getRole(userType);
		this.usage = usage;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		
	}

	private void validate(String userId) {
		
	}
}
/*
`user_id` VARCHAR(45) NOT NULL,
`user_pw` VARCHAR(200) NOT NULL,
`user_type` INT(1) NOT NULL COMMENT '사용자의구분/권한 ( 4:관리자/3:원장/2:교사/1:코디/0:학생)',
`use_yn` INT(1) NOT NULL COMMENT '사용여부',
`name` VARCHAR(20) NULL,
`mobile` VARCHAR(15) NULL,
`email` VARCHAR(200) NULL,
`student_no` INT(10) NULL,
`input_id` VARCHAR(45) NOT NULL,
`input_date` DATETIME NOT NULL,
`update_id` VARCHAR(45) NULL,
`update_date` DATETIME NULL,
PRIMARY KEY (`user_id`))
*/