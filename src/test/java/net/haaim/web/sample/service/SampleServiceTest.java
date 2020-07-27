package net.haaim.web.sample.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.repository.SampleRepository;
import net.jtheway.web.sample.service.SampleService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("local")
public class SampleServiceTest {

	@Autowired
	private SampleRepository repo;

	@Autowired
	private SampleService service;

	@BeforeEach
	public void init() {
		System.out.println(repo);
		repo.deleteAll();

		SampleEntity entity = new SampleEntity();
		entity.setAge(10);
		entity.setName("hong");
		repo.saveAndFlush(entity);
	}

	@Test
	public void testSearch() {
		SampleEntity entity = service.search("hong");
		System.out.println("dkdkd");
		Assertions.assertNotEquals(null, entity);
		Assertions.assertEquals("hong", entity.getName());
		Assertions.assertEquals(10, entity.getAge());
		
	}
	
	@Test
	public void searchAll() {
		Assertions.assertEquals(1, service.searchAll().size());
		
	}
	
	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
