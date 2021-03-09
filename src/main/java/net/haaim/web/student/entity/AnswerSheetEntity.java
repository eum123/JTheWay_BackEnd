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
@Table(name = "answer_sheet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AnswerSheetEntity extends CommonEntity {
	

	@Column(name = "student_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer studentNo;
	
	@Column(name = "exam_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer examNo;
		
	@Column(name = "question_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer questionNo;
	
	@Column(name = "answer")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String answer;
	
	@Column(name = "file_path")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String filePath;
	
	@Column(name = "result")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer result;
	
	@Builder
	public AnswerSheetEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer studentNo,
			Integer examNo, Integer questionNo, String answer, String filePath, Integer result) {
		super(inputId, inputDate, updateId, updateDate);
		this.studentNo = studentNo;
		this.examNo = examNo;
		this.questionNo = questionNo;
		this.answer = answer;
		this.filePath = filePath;
		this.result = result;
	}
}
