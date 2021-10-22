package net.haaim.web.api.system.code.entity;

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
	private String groupCode;
	private String code;
	private String codeName;
	private Integer useYn;
	
}
