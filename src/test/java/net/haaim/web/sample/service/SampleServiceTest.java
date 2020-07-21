package net.haaim.web.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.repository.SampleRepository;
import net.jtheway.web.sample.service.SampleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class SampleServiceTest {

	@Autowired
	private SampleRepository repo;

	@Autowired
	private SampleService service;

	@Before
	public void init() {
		repo.deleteAll();

		SampleEntity entity = new SampleEntity();
		entity.setAge(10);
		entity.setName("hong");
		repo.saveAndFlush(entity);
	}

	@Test
	public void search() {
		SampleEntity entity = service.search("hong");
		
		assertNotEquals(null, entity);
		assertEquals("hong", entity.getName());
		assertEquals(10, entity.getAge());
	}
	
	@Test
	public void searchAll() {
		assertEquals(1, service.searchAll().size());
	}
	
	@After
	public void destory() {
		repo.deleteAll();
	}
}
