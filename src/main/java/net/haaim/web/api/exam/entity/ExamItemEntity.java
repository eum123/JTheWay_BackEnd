package net.haaim.web.api.exam.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ExamItemEntity extends CommonEntity {
	private Integer examNo;
	private Integer no;
	private Integer itemNo;
	private String questionType;
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private String filePath;
	private Integer markType;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String answer = null;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String answerPath = null;
}
