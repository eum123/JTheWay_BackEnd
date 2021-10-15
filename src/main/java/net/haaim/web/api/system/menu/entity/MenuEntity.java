package net.haaim.web.api.system.menu.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MenuEntity extends CommonEntity{
	private String menuCode;

	private String menuName;
	
	private String parentMenuCode;

	private Integer depth;

	private String url;

	private Integer useYn = 0;
	
	private Integer sort;
}
