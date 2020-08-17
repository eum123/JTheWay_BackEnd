package net.haaim.web.code.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.repository.CodeRepository;

@SpringBootTest
@ActiveProfiles("local")
public class CodeServiceTest {

	@Autowired
	private CodeRepository repo;

	@Autowired
	private CodeService service;

	@BeforeEach
	public void init() {
		
		repo.save(CodeEntity.builder().code("1").groupCode("1").codeName("1").inputDate(new Date()).inputId("id")
				.build());
		repo.save(CodeEntity.builder().code("2").groupCode("1").codeName("2").inputDate(new Date()).inputId("id")
				.build());
		repo.save(CodeEntity.builder().code("1").groupCode("2").codeName("1").inputDate(new Date()).inputId("id")
				.build());
		repo.flush();
	}
	
	@Test
	public void testSecarchGroupCode() {
		List<CodeEntity> list = service.search("1");
		Assertions.assertNotNull(list);
		Assertions.assertEquals(2, list.size());
		
		//desc
		Assertions.assertEquals(list.get(0).getCodeName(), "2");
		Assertions.assertEquals(list.get(1).getCodeName(), "1");
	}

	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
