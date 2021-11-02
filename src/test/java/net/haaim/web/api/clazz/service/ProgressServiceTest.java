package net.haaim.web.api.clazz.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import com.github.pagehelper.Page;

import net.haaim.web.api.clazz.entity.ProgressListResponse;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class ProgressServiceTest {

	@Autowired
	private ProgressService service;
	
	@Test
	public void findAllByYearAndGradeAndClassNameAndMemberIdAndOwner() {
		//데이터 저장
		
		//실행.
		Page<ProgressListResponse> list = service.findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(
				2021, 1, "class_name", "haaim01", 2, "haaim01");
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	@Test
	public void findAllByYearAndGradeAndClassNameAndMemberIdAndOwnerAdmin() {
		//데이터 저장
		
		//실행.
		Page<ProgressListResponse> list = service.findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(
				2021, 1, null, null, 4, "admin");
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	
}
