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
public class MonthlyClassDTO extends CommonEntity{

	@Column(name = "class_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private Integer classNo;
	
	@Column(name = "class_name")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private String className;
	
	@Column(name = "start_date")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private String startDate;
	
	@Column(name = "end_date")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private String endDate;
	
	@Column(name = "day_time")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private String dayTime;
	
	@Builder
	public MonthlyClassDTO(String inputId, Date inputDate, String updateId, Date updateDate, Integer classNo,
			String className, String startDate, String endDate, String dayTime) {
		super(inputId, inputDate, updateId, updateDate);
		this.classNo = classNo;
		this.className = className;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dayTime = dayTime;
	}
}
