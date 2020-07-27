package net.haaim.web.sample.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.repository.SampleRepository;

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
		
		Assertions.assertEquals(1, repo.count());
		
		Assertions.assertTrue(repo.existsById("hong"));
		
		
		repo.deleteAll();
	}
}
