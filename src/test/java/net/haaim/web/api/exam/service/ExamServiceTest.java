package net.haaim.web.api.exam.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import com.github.pagehelper.Page;

import net.haaim.web.api.exam.entity.ExamListEntity;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class ExamServiceTest {

	@Autowired
	private ExamService service;
	
	@Test
	public void findAllByStudentNoTest() {
		//데이터 저장
		
		//실행.
		Page<ExamListEntity> list = service.findAllByStudentNo(1, 1, 10);
		System.out.println(list.size());
		
		//조건 비교.
	}
}
