package net.haaim.web.clazz.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity 
@Table(name = "class")
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClazzEntity extends CommonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer classNo;
	
	@Column(name = "year")
	@JsonProperty(value = "year", access = JsonProperty.Access.AUTO)
	private Integer year;
	
	@Column(name = "class_name")
	@JsonProperty(value = "class_name", access = JsonProperty.Access.AUTO)
	private String className;
	
	@Column(name = "start_date")
	@JsonProperty(value = "start_date", access = JsonProperty.Access.AUTO)
	private String startDate;
	
	@Column(name = "end_date")
	@JsonProperty(value = "end_date", access = JsonProperty.Access.AUTO)
	private String endDate;
	
	@Column(name = "day_time")
	@JsonProperty(value = "day_time", access = JsonProperty.Access.AUTO)
	private String dayTime;
	
	@Column(name = "textbook")
	@JsonProperty(value = "textbook", access = JsonProperty.Access.AUTO)
	private String textBook;
	
	@Column(name = "pass_score")
	@JsonProperty(value = "pass_score", access = JsonProperty.Access.AUTO)
	private Integer passScore;
	
	@Column(name = "description")
	@JsonProperty(value = "description", access = JsonProperty.Access.AUTO)
	private String description;
	
	@Column(name = "curriculum_no")
	@JsonProperty(value = "curriculum_no", access = JsonProperty.Access.AUTO)
	private Integer curriclumNo;
	
	@Column(name = "teacher_no")
	@JsonProperty(value = "teacher_no", access = JsonProperty.Access.AUTO)
	private Integer teacherNo;

	
	@Builder
	public ClazzEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer year,
			String className, String startDate, String endDate, String dayTime, String textBook,
			Integer passScore, String description, Integer curriclumNo, Integer course, Integer teacherNo, String name) {
		
		super(inputId, inputDate, updateId, updateDate);

		this.year = year;
		this.className = className;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dayTime = dayTime;
		this.textBook = textBook;
		this.passScore = passScore;
		this.description = description;
		this.curriclumNo = curriclumNo;
		this.teacherNo = teacherNo;
	}
	

	
	private void validate(String userId) {
		
	}
}

