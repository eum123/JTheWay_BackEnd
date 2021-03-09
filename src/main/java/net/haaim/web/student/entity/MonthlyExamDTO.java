package net.haaim.web.student.entity;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MonthlyExamDTO extends CommonEntity {
	
	@Column(name = "pass")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private Integer pass;
	
	@Column(name = "fail")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer fail;
	
	@Column(name = "not_submit")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer notSubmit;
	
	@Column(name = "remain")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer remain;
	
	@Builder
	public MonthlyExamDTO(String inputId, Date inputDate, String updateId, Date updateDate, Integer pass,
			Integer fail, Integer notSubmit, Integer remain) {
		super(inputId, inputDate, updateId, updateDate);
		this.pass = pass;
		this.fail = fail;
		this.notSubmit = notSubmit;
		this.remain = remain;
	}
}
