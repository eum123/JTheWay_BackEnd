package net.haaim.web.api.clazz.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ClassListResponse {
	private Integer classNo;
	
	private Integer year;
	private String className;
		
	//인원수.
	private Integer count;
	
	private String startDate;
	private String endDate;
	private String dayTime;
	private String teacherName;
	
	private List<CurriculumEntity> curriculumList = new ArrayList();
	
	private String curriculum;
	public void setCurriculum(String curriculum) {
		String[] str = curriculum.split(",");
		for(String c : str) {
			
			String[] element = c.split("---");
			CurriculumEntity e = new CurriculumEntity();
			e.setYear(Integer.valueOf(element[0]));
			e.setGrade(element[1]);
			e.setCourse(element[2]);
			e.setLargeCategory(element[3]);
			e.setMediumCategory(element[4]);
			
			curriculumList.add(e);
		}
	}
	
}
