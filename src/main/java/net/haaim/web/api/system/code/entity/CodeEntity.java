package net.haaim.web.api.system.code.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CodeEntity extends CommonEntity {
	
	
	private String groupCode = "";
	
	@NotBlank(message = "code는 필수 값입니다.")
	@NotEmpty(message="code는 필수 값입니다.")
	private String code;
	
	@NotBlank(message = "코드이름은 필수 값입니다.")
	@NotEmpty(message="코드이름은 필수 값입니다.")
	private String codeName;
	
	private Integer useYn = 1;
	
}
