package net.haaim.web.api.clazz.entity;

import org.junit.jupiter.api.Test;

public class ClassListResponseTest {

	@Test
	public void setCurriculumTest() {
		ClassListResponse obj = new ClassListResponse();
		String data = "2021---고2---수학1---H2102---07,2021---고2---수학1---H2103---08,2021---고2---수학1---H2103---09,2021---고2---수학1---H2103---10,2021---고2---수학2---H2201---01,2021---고2---수학2---H2201---02";
		
		obj.setCurriculum(data);
		
		System.out.println(obj.getCurriculumList().size());
		System.out.println(obj.getCurriculumList());
	}
}
