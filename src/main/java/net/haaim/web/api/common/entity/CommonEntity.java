package net.haaim.web.api.common.entity;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CommonEntity {
	
	public static final int VIEW = 1;
	
	private String inputId = "";

	private Date inputDate = new Date();

	private String updateId = "";

	private Date updateDate = new Date();
	
	protected CommonEntity(String inputId, Date inputDate, String updateId, Date updateDate) {
		this.inputId = inputId;
		this.inputDate = inputDate;
		this.updateId = updateId;
		this.updateDate = updateDate;
	}

}
