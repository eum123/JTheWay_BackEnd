package net.haaim.web.api.clazz.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ClassEntity extends CommonEntity{
	private Integer classNo;
	
	@NotEmpty(message = "기간은 필수 값입니다.")
	private Integer year;
	private String className;
	
	@NotEmpty(message = "클래스 시작 기간은 필수 값입니다.")
	private String startDate;
	@NotEmpty(message = "클래스 시작 기간은 필수 값입니다.")
	private String endDate;
	private String dayTime;
	private String textBook;
	
	@PositiveOrZero(message="0 보다 커야 합니다.")
	private Integer passScore;
	private String description;
	private Integer status;
}
