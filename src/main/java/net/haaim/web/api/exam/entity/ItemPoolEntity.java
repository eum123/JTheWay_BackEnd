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
public class ItemPoolEntity extends CommonEntity {
	private Integer itemNo;
	/* 일자 */
	private Integer year;
	
	private String grade;
	
	private String course;
	
	private String largeCategory;
	
	private String mediumCategory;
	
	private String typeGroup;

	private String type;
	private Integer questionType = null;
	private String question = null;
	private String choice1 = null;
	private String choice2 = null;
	private String choice3 = null;
	private String choice4 = null;
	private String choice5 = null;
	private String filePath = null;
	private Integer markType = null;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String answer = null;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String answerPath = null;
	
	public String publisher;
	private String workbook;
	private Integer levelDifficulty;
	private Integer useYn;
	
}
