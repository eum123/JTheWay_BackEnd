package net.haaim.web.api.student.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class StudentListResponse {
	private Integer year;
	private Integer studentNo;
	private String school;
	private String grade;
	private String name;
	private String mobile;
	private String parent1Mobile;
	private String parent2Mobile;
	private String className;
	private Integer classNo;
	private Date inputDate;
}
