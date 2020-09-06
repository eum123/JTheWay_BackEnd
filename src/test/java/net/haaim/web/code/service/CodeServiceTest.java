package net.haaim.web.code.service;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.repository.CodeRepository;
import net.haaim.web.common.request.CustomPageRequest;

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
		PageRequest pageable = CustomPageRequest.of(1, 10, "no");
		
		Page<CodeEntity> list = service.search(pageable);
		Assertions.assertNotNull(list);
		Assertions.assertEquals(2, list.toList().size());
		
		//desc
		Assertions.assertEquals(list.toList().get(0).getCodeName(), "2");
		Assertions.assertEquals(list.toList().get(1).getCodeName(), "1");
	}

	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
