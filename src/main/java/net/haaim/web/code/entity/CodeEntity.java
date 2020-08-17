package net.haaim.web.code.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "code_mngt")
@IdClass(CodeEntityKey.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CodeEntity extends CommonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8113141283039879647L;

	@Id
	@Column(name = "group_code")
	@JsonProperty(value = "group_code", access = JsonProperty.Access.WRITE_ONLY)
	private String groupCode = null;
	
	@Id
	@Column(name = "code")
	@JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
	private String code = null;
	
	@Column(name = "code_name")
	@JsonProperty(value = "code_name", access = JsonProperty.Access.WRITE_ONLY)
	private String codeName = "";
	
	@Column(name = "use_yn")
	@JsonProperty(value = "use_yn", access = JsonProperty.Access.WRITE_ONLY)
	private int usage = 0;
	
	@Builder
	public CodeEntity(String groupCode, String code, String codeName, int usage, String inputId, Date inputDate, String updateId,
			Date updateDate) {

		super(inputId, inputDate, updateId, updateDate);

		validate(groupCode, code);
		
		this.groupCode = groupCode;
		this.code = code;
		this.codeName = codeName;
		this.usage = usage;

	}
	private void validate(String groupCode, String code) {
		Assert.hasText(groupCode, "groupCode must not be empty");
		Assert.hasText(code, "code must not be empty");
	}
}

/**

CREATE TABLE IF NOT EXISTS `haaim`.`code_mngt` (
`group_code` VARCHAR(20) NOT NULL COMMENT '그룹코드',
`code` VARCHAR(20) NOT NULL COMMENT '코드',
`code_name` VARCHAR(100) NOT NULL COMMENT '코드명',
`use_yn` INT(1) NOT NULL COMMENT '사용여부',
`codename2` VARCHAR(100) NULL COMMENT '코드명2',
`codename3` VARCHAR(100) NULL COMMENT '코드명3',
`input_id` VARCHAR(45) NOT NULL,
`input_date` DATETIME NOT NULL,
`update_id` VARCHAR(45) NULL,
`update_date` DATETIME NULL,
PRIMARY KEY (`group_code`, `code`))
ENGINE = InnoDB
COMMENT = '코드';

*/