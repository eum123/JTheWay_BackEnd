package net.haaim.web.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.Role;
import net.haaim.web.common.entity.CommonEntity;


@Entity 
@Table(name = "user")
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends CommonEntity {
	//implements UserDetails {
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer no;

	@Column(name = "user_id")
	@JsonProperty(value = "user_id", access = JsonProperty.Access.AUTO)
	private String userId;
	
	@Column(name = "user_pw")
	@JsonProperty(value = "user_pw", access = JsonProperty.Access.AUTO)
	private String userPassword;
	
	@Column(name = "user_type")
	@JsonProperty(value = "user_type", access = JsonProperty.Access.AUTO)
	private Role userType;
	
	@Column(name = "use_yn")
	@JsonProperty(value = "use_yn", access = JsonProperty.Access.AUTO)
	private int usage;
	
	@Column(name = "name")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String name;
	
	@Column(name = "mobile")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String mobile;
	
	@Column(name = "email")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String email;
	
	@Column(name = "student_no")
	@JsonProperty(value = "student_no", access = JsonProperty.Access.AUTO)
	private Integer studentNo;
	
	/** 상태(0:HIDDEN/1:VIEW) */
	@Column(name = "state", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer state; 
	
	@OneToOne
	@JoinColumn(name = "student_no",
			referencedColumnName = "student_no",
			insertable=false, updatable=false)	
	private StudentInfoEntity studentInfo;
	
	
	@Builder
	public UserEntity(String userId, String userPassword, int userType
			, int usage, String name, String mobile, String email, Integer studentNo
			, int state, String inputId, Date inputDate, String updateId, Date updateDate) {
		super(inputId, inputDate, updateId, updateDate);
		
		validate(userId);
		
		this.userId = userId;
		this.userPassword = userPassword;
		this.userType = Role.getRole(userType);
		this.usage = usage;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.studentNo = studentNo;
		this.state = state;
		
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