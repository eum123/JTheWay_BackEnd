package net.jtheway.web.sample.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import net.jtheway.web.sample.entity.SampleEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class SampleRepositoryTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SampleRepository repo;
	
	@Test
	public void select() {
		
		repo.deleteAll();
		
		SampleEntity entity = new SampleEntity();
		entity.setAge(10);
		entity.setName("hong");
		repo.saveAndFlush(entity);
		
		assertEquals(1, repo.count());
		
		assertTrue(repo.exists("hong"));
		
		
		repo.deleteAll();
	}
}
