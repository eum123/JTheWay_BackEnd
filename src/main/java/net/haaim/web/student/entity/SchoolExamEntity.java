package net.haaim.web.student.entity;

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
@Table(name = "score_mngt")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SchoolExamEntity extends CommonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private Integer no;
	
	@Column(name = "student_no")
	@JsonProperty(value = "student_no", access = JsonProperty.Access.AUTO)
	private Integer studentNo;
	
	@Column(name = "year")
	@JsonProperty(value = "year", access = JsonProperty.Access.AUTO)
	private int year;
	
	@Column(name = "term")
	@JsonProperty(value = "term", access = JsonProperty.Access.AUTO)
	private String term;
	
	@Column(name = "exam")
	@JsonProperty(value = "exam", access = JsonProperty.Access.AUTO)
	private String exam;
	
	@Column(name = "score")
	@JsonProperty(value = "score", access = JsonProperty.Access.AUTO)
	private String score;
	
	@Column(name = "description")
	@JsonProperty(value = "description", access = JsonProperty.Access.AUTO)
	private String description;
	

	@Builder
	public SchoolExamEntity(Integer studentNo, int year, String term, String exam, String score, String description, String inputId, Date inputDate, String updateId, Date updateDate) {
		
		super(inputId, inputDate, updateId, updateDate);
		
		this.studentNo = studentNo;
		this.year = year;
		this.term = term;
		this.exam = exam;
		this.score = score;
		this.description = description;
		
	}
	
	private void validate(String userId) {
		
	}
}
