package net.haaim.web.api.clazz.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ClassCurriculumEntity extends CommonEntity{
	
	@NotEmpty(message = "class_no은 필수 값입니다.")
	private Integer classNo;	
	
	@NotEmpty(message = "cur_id은 필수 값입니다.")
	private Integer curId;
	private String typeGroup;
	private String cDate;
	private String cTime;	
	private Integer status = 1;
	
	@Builder
	public ClassCurriculumEntity(Integer classNo, Integer curId, String typeGroup, 
			String cDate, String cTime, Integer status, String inputId) {
		this.classNo = classNo;
		this.curId = curId;
		this.typeGroup = typeGroup;
		this.cDate = cDate;
		this.cTime = cTime;
		this.status = status;
		super.setInputId(inputId);
	}
}
