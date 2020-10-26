package net.haaim.web.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "student_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class StudentInfoEntity extends CommonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_no")
	@JsonProperty(value = "student_no", access = JsonProperty.Access.AUTO)
	@OneToOne(mappedBy = "studentInfoEntity")	
	private Long studentNo;

	@Column(name = "name")
	@JsonProperty(value = "info_name", access = JsonProperty.Access.AUTO)
	private String name;

	@Column(name = "birth")
	@JsonProperty(value = "info_birth", access = JsonProperty.Access.AUTO)
	private String birth;

	@Column(name = "mobile")
	@JsonProperty(value = "info_mobile", access = JsonProperty.Access.AUTO)
	private String mobile;

	@Column(name = "email")
	@JsonProperty(value = "info_email", access = JsonProperty.Access.AUTO)
	private String email;

	@Column(name = "father_mobile")
	@JsonProperty(value = "info_father_mobile", access = JsonProperty.Access.AUTO)
	private String fatherMobile;

	@Column(name = "mother_mobile")
	@JsonProperty(value = "info_mother_mobile", access = JsonProperty.Access.AUTO)
	private String motherMobile;

	@Builder
	public StudentInfoEntity(long studentNo, String name, String birth, String mobile, String email, String fatherMobile, String motherMobile, String inputId, Date inputDate, String updateId, Date updateDate) {
		
		super(inputId, inputDate, updateId, updateDate);
		
		this.studentNo = studentNo;
		this.name = name;
		this.birth = birth;
		this.mobile = mobile;
		this.email = email;
		this.fatherMobile = fatherMobile;
		this.motherMobile = motherMobile;
		
	}
	
	private void validate(String userId) {
		
	}
}
