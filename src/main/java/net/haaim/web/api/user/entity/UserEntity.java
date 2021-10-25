package net.haaim.web.api.user.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class UserEntity extends CommonEntity{
	private String userName;
	private String password;
	private Integer uType;
	private Integer studentNo;
	private String name;
	private String mobile;
	private String eamil;
	private Integer state;
}
