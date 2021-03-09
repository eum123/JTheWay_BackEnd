package net.haaim.web.student.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "exam_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExamUserEntity extends CommonEntity {
	
	@Column(name = "exam_no")
	@JsonProperty(value = "exam_no", access = JsonProperty.Access.AUTO)
	private Integer examNo;
	
	@Column(name = "student_no")
	@JsonProperty(value = "student_no", access = JsonProperty.Access.AUTO)
	private Integer studentNo;
	
	@Column(name = "status")
	@JsonProperty(value = "status", access = JsonProperty.Access.AUTO)
	private int status;
	
	@Column(name = "score")
	@JsonProperty(value = "score", access = JsonProperty.Access.AUTO)
	private String score;
	
	@Column(name = "comments")
	@JsonProperty(value = "comments", access = JsonProperty.Access.AUTO)
	private String comments;
	
	@Builder
	public ExamUserEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer examNo,
			Integer studentNo, int status, String score, String comments) {
		super(inputId, inputDate, updateId, updateDate);
		this.examNo = examNo;
		this.studentNo = studentNo;
		this.status = status;
		this.score = score;
		this.comments = comments;
	}
}
