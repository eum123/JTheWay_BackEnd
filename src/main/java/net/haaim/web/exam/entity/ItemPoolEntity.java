package net.haaim.web.exam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "item_pool")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemPoolEntity extends CommonEntity {
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Long itemNo;

	@Column(name = "year", nullable = true, unique = false, length = 4)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer year;

	@Column(name = "grade", nullable = true, unique = false, length = 2)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer grade;
	
	@Column(name = "course", nullable = true, unique = false, length = 4)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer course;
	
	@Column(name = "medium_category", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String mediumCategory = null;
	
	@Column(name = "type_group", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String typeGroup = null;
	
	@Column(name = "type", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String type = null;
	
	@Column(name = "question_type", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String questionType = null;
	
	@Column(name = "question", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String question = null;
	
	@Column(name = "choice1", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice1 = null;
	
	@Column(name = "choice2", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice2 = null;
	
	@Column(name = "choice3", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice3 = null;
	
	@Column(name = "choice4", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice4 = null;
	
	@Column(name = "choice5", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String choice5 = null;
	
	@Column(name = "file_path", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String filePath = null;
	
	@Column(name = "mark_type", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer markType = null;
	
	@Column(name = "answer", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String answer = null;
	
	@Column(name = "answer_path", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String answerPath = null;
	
	@Column(name = "publisher", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String publisher = null;
	
	@Column(name = "workbook", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String workbook = null;
	
	@Column(name = "level_difficulty", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String levelDifficult = null;
	
	/** 상태(0:HIDDEN/1:VIEW) */
	@Column(name = "useYn", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer useYn;

	@Builder
	public ItemPoolEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer year,
			Integer grade, Integer course, String mediumCategory, String typeGroup, String type, String questionType,
			String question, String choice1, String choice2, String choice3, String choice4, String choice5,
			String filePath, Integer markType, String answer, String answerPath, String publisher, String workbook,
			String levelDifficult, Integer useYn) {
		super(inputId, inputDate, updateId, updateDate);
		this.year = year;
		this.grade = grade;
		this.course = course;
		this.mediumCategory = mediumCategory;
		this.typeGroup = typeGroup;
		this.type = type;
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
		this.publisher = publisher;
		this.workbook = workbook;
		this.levelDifficult = levelDifficult;
		this.useYn = useYn;
		
		//TODO : validation 추가 구현
		validate(mediumCategory, typeGroup);
	}
	
	private void validate(String title, String contents) {
		Assert.hasText(title, "title must not be empty");
		Assert.hasText(contents, "contents must not be empty");
	}
}
