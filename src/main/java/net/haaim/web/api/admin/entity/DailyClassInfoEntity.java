package net.haaim.web.api.admin.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DailyClassInfoEntity {
	private Integer classNo;
	private String className;
	private Date date;
	private Integer passScore;
	private String atd;
	private String test;
	private Integer pass;
	private Float average;
	private String dayTime;
	private String name;
}
