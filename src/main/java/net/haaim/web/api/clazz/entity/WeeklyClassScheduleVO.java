package net.haaim.web.api.clazz.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class WeeklyClassScheduleVO {
	private String baseDate;
	private String cdate;
	private String ctime;
	private Integer classNo;
	private String className;
	private String startDate;
	private String endDate;
}
