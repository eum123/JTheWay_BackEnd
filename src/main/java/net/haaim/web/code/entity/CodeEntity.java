package net.haaim.web.code.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "code")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CodeEntity extends CommonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8113141283039879647L;
	
	public static final int VIEW = 1;
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private int no;

	@Column(name = "group_code")
	@JsonProperty(value = "group_code", access = JsonProperty.Access.AUTO)
	private String groupCode = null;
	
	@Column(name = "code")
	@JsonProperty(value = "code", access = JsonProperty.Access.AUTO)
	private String code = null;
	
	@Column(name = "code_name")
	@JsonProperty(value = "code_name", access = JsonProperty.Access.AUTO)
	private String codeName = "";
	
	@Column(name = "use_yn")
	@JsonProperty(value = "use_yn", access = JsonProperty.Access.AUTO)
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
