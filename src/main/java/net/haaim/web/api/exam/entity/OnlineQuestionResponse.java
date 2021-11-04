package net.haaim.web.api.exam.entity;

import java.util.List;

import lombok.Builder;

public class OnlineQuestionResponse {
	private Integer classNo;
	private String className;
	
	private String grade;
	private String course;
	private String largetCategory;
	private String mediumCategory;
	
	private List<ExamItemEntity> list;
	
	@Builder
	public OnlineQuestionResponse(Integer classNo, String className, String grade, 
			String course, String largeCategory, String mediumCategory, List<ExamItemEntity> list) {
		this.classNo = classNo;
		this.className = className;
		this.grade = grade;
		this.course = course;
		this.largetCategory = largeCategory;
		this.mediumCategory = mediumCategory;
		this.list = list;
	}
	
	
}
