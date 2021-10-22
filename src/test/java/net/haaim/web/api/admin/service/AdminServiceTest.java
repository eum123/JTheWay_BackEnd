package net.haaim.web.api.admin.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.admin.entity.DailyClassInfoEntity;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class AdminServiceTest {

	@Autowired
	private AdminService service;
	
	@Test
	public void findAllByStudentNoTest() {
		//데이터 저장
		
		//실행.
		List<DailyClassInfoEntity> list = service.dailyClassInfoList();
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	
}
