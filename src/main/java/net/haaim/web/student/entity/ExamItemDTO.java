package net.haaim.web.student.entity;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExamItemDTO extends CommonEntity {

	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private Integer no;
	
	@Column(name = "item_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer itemNo;
	
	@Column(name = "exam_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer examNo;
		
	@Column(name = "question_type")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer questionType;
	
	@Column(name = "question")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String question;
	
	@Column(name = "choice1")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice1;
	
	@Column(name = "choice2")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice2;
	
	@Column(name = "choice3")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice3;
	
	@Column(name = "choice4")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice4;
	
	@Column(name = "choice5")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice5;
	
	@Column(name = "file_path")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String filePath;
	
	@Column(name = "mark_type")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer markType;
	
	@Column(name = "answer")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String answer;
	
	@Column(name = "answer_path")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String answerPath;
	
	@Builder
	public ExamItemDTO(String inputId, Date inputDate, String updateId, Date updateDate, Integer no, Integer itemNo,
			Integer examNo, Integer questionType, String question, String choice1, String choice2, String choice3,
			String choice4, String choice5, String filePath, Integer markType, String answer, String answerPath) {
		super(inputId, inputDate, updateId, updateDate);
		this.no = no;
		this.itemNo = itemNo;
		this.examNo = examNo;
		this.questionType = questionType;
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.choice5 = choice5;
		this.filePath = filePath;
		this.markType = markType;
		this.answer = answer;
		this.answerPath = answerPath;
	}
}
