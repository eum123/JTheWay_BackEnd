package net.haaim.web.api.system.code.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.system.code.entity.CodeGroupEntity;
import net.haaim.web.api.system.code.repository.CodeGroupMapper;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class CodeGroupServiceTest {

	@Autowired
	private CodeGroupService serivce;
	
	@Autowired
	private CodeGroupMapper mapper;
	
	@Test
	public void findAllTest() {
		//데이터 저장
		
		//실행.
		List<CodeGroupEntity> list = serivce.findAllByUseYn(null);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	@Test
	public void findAllByUseYnTest() {
		//데이터 저장
		
		//실행.
		List<CodeGroupEntity> list = serivce.findAllByUseYn(1);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
}
