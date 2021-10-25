package net.haaim.web.api.clazz.entity;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CurriculumEntity extends CommonEntity {
	private Integer cno;
	
	@NotEmpty(message = "기간은 필수 값입니다.")
	private Integer year;
	
	@NotEmpty(message = "학년은 필수 값입니다.")
	private Integer grade;
	
	@NotEmpty(message = "학기/과정은 필수 값입니다.")
	private Integer course;
	private String largeCategory;
	private String mediumCategory;
}
