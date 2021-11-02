package net.haaim.web.api.clazz.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import com.github.pagehelper.Page;

import net.haaim.web.api.clazz.entity.ClassListResponse;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class ClassServiceTest {

	@Autowired
	private ClassService service;
	
	@Test
	public void findAllByYearAndGradeAndCourseAndLargeCategorAndStatus() {
		//데이터 저장
		
		
		//실행.
		Page<ClassListResponse> list = service.findAllByYearAndGradeAndCourseAndLargeCategorAndStatus(
				2021, "1학기", "1학", "largeCategory", 1);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	@Test
	public void findAllByYearAndGradeAndCourseAndLargeCategorAndStatus2() {
		//데이터 저장
		
		
		//실행.
		Page<ClassListResponse> list = service.findAllByYearAndGradeAndCourseAndLargeCategorAndStatus(
				null, null, null, null, 1);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	
	
}
