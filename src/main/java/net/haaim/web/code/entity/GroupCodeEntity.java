package net.haaim.web.code.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.code.entity.CodeEntity.CodeEntityBuilder;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "group_code")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GroupCodeEntity extends CommonEntity implements Serializable {
public static final int VIEW = 1;
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int no;
	
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
	public GroupCodeEntity(String code, String codeName, int usage, String inputId, Date inputDate, String updateId,
			Date updateDate) {

		super(inputId, inputDate, updateId, updateDate);

		validate(code);
		
		this.code = code;
		this.codeName = codeName;
		this.usage = usage;

	}
	private void validate(String code) {
		Assert.hasText(code, "code must not be empty");
	}
}
