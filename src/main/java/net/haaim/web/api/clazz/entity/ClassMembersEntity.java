package net.haaim.web.api.clazz.entity;

import javax.validation.constraints.NotEmpty;

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
public class ClassMembersEntity extends CommonEntity {

	@NotEmpty(message = "class_no은 필수 값입니다.")
	private Integer classNo;

	@NotEmpty(message = "member_type은 필수 값입니다.")
	private Integer memberType;
	private String memberNo;
	private Integer status;

	@Builder
	public ClassMembersEntity(Integer classNo, Integer memberType, String memberNo, 
			Integer status, String inputId) {
		this.classNo = classNo;
		this.memberType = memberType;
		this.memberNo = memberNo;
		this.status = status;
		this.setInputId(inputId);
		
	}
}
