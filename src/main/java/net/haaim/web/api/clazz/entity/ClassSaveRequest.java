package net.haaim.web.api.clazz.entity;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ClassSaveRequest extends ClassEntity {
	//curriculum cno 목록.
	private List<Integer> curriculumList;
	
	// student_no 목록.
	private List<Integer> studentList;
	private String teacherId;
}
