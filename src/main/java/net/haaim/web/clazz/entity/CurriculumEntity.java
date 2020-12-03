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
@Table(name = "curriculum")
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CurriculumEntity extends CommonEntity {
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer no;
	
	@Column(name = "year")
	@JsonProperty(value = "year", access = JsonProperty.Access.AUTO)
	private Integer year;
	
	@Column(name = "grade")
	@JsonProperty(value = "grade", access = JsonProperty.Access.AUTO)
	private Integer grade;
	
	@Column(name = "course")
	@JsonProperty(value = "course", access = JsonProperty.Access.AUTO)
	private Integer course;
	
	@Column(name = "large_category")
	@JsonProperty(value = "large_category", access = JsonProperty.Access.AUTO)
	private String largeCategory;
	
	@Column(name = "medium_category")
	@JsonProperty(value = "medium_category", access = JsonProperty.Access.AUTO)
	private String mediumCategory;
	
	@Builder
	public CurriculumEntity(Integer year,
			Integer grade, Integer course, String largeCategory, String mediumCategory,
			String inputId, Date inputDate, String updateId, Date updateDate) {
		super(inputId, inputDate, updateId, updateDate);
		this.year = year;
		this.grade = grade;
		this.course = course;
		this.largeCategory = largeCategory;
		this.mediumCategory = mediumCategory;
	}

}
/*
`no` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`year` INT(4) NOT NULL,
`grade` INT(2) NOT NULL COMMENT '학년',
`course` INT(4) NOT NULL COMMENT '학기/과정',
`large_category` VARCHAR(10) NULL COMMENT '대분류',
`medium_category` VARCHAR(10) NULL COMMENT '중분류',
`input_id` VARCHAR(45) NOT NULL,
`input_date` DATETIME NOT NULL,
`update_id` VARCHAR(45) NULL,
`update_date` DATETIME NULL
*/