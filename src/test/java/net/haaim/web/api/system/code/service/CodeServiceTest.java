package net.haaim.web.api.system.code.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.system.code.entity.CodeEntity;
import net.haaim.web.api.system.code.repository.CodeMapper;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class CodeServiceTest {

	@Autowired
	private CodeService serivce;
	
	@Autowired
	private CodeMapper mapper;
	
	@Test
	public void findAllTest() {
		//데이터 저장
		
		//실행.
		List<CodeEntity> list = serivce.findAllByCodeNameAndUseYn(null, null);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	@Test
	public void findAllByUseYnTest() {
		//데이터 저장
		
		//실행.
		List<CodeEntity> list = serivce.findAllByCodeNameAndUseYn(null, 1);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
}
