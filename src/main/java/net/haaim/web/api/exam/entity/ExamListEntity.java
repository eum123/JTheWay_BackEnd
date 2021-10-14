package net.haaim.web.api.exam.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ExamListEntity {
	/* 일자 */
	private Integer year;
	
	/* 클래스 번호. */
	private Integer classNo;
	
	/* 커리큘럼. */
	private String cur;
	
	/* 출제일 */
	private Date sdate;
	
	/* 응시일 */
	private Date inputDate;
	
	/* 문항수 */
	private Integer count;
	
	/* 점수 */
	private Integer score;
	
	/* pass여부 */
	private String pass;
	
	/* 응시여부 */
	private String stare;
	
}
