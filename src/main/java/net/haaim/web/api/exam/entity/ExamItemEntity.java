package net.haaim.web.api.exam.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ExamItemEntity {
	private Integer itemNo;
	private Integer year;
	private Integer grade;
	private Integer course;
	private String mediumCategory = null;
	private String typeGroup = null;
	private String type = null;
	private Integer questionType = null;
	private String question = null;
	private String choice1 = null;
	private String choice2 = null;
	private String choice3 = null;
	private String choice4 = null;
	private String choice5 = null;
	private String filePath = null;
	private Integer markType = null;
	private String answer = null;
	private String answerPath = null;
	private String publisher = null;
	private String workbook = null;
	private Integer levelDifficult = null;
	private Integer useYn;
}
