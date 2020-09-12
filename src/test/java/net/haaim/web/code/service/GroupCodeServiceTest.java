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

import net.haaim.web.code.entity.GroupCodeEntity;
import net.haaim.web.code.repository.GroupCodeRepository;

@SpringBootTest
@ActiveProfiles("local")
public class GroupCodeServiceTest {

	@Autowired
	private GroupCodeRepository repo;

	@Autowired
	private GroupCodeService service;

	@BeforeEach
	public void init() {
		
		repo.save(GroupCodeEntity.builder().code("1").codeName("1").inputDate(new Date()).inputId("id")
				.build());
		repo.save(GroupCodeEntity.builder().code("2").codeName("2").inputDate(new Date()).inputId("id")
				.build());
		repo.save(GroupCodeEntity.builder().code("1").codeName("1").inputDate(new Date()).inputId("id")
				.build());
		repo.flush();
	}
	
	@Test
	public void testSearchGroupCode() {
		
		List<GroupCodeEntity> list = service.searchAll();
		Assertions.assertNotNull(list);
		Assertions.assertEquals(3, list.size());
		

	}

	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
