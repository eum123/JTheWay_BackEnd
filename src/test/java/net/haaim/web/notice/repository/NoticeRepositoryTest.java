package net.haaim.web.notice.repository;

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

import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.notice.entity.NoticeEntity;

@SpringBootTest
@ActiveProfiles("local")
public class NoticeRepositoryTest {
	@Autowired
	private NoticeRepository repo;
	
	@BeforeEach
	public void init() {
		repo.deleteAll();
		
		repo.saveAndFlush(NoticeEntity.builder().title("title")
				.contents("contents")
				.state(1)
				.inputId("id")
				.inputDate(new Date())
				.build());
	}
	
	
	
	@Test
	public void testSearchAll() {
		PageRequest pageRequest = CustomPageRequest.of(1, 10, "no");
		Page<NoticeEntity> list = repo.findAll(pageRequest);
		
		Assertions.assertEquals(1, list.getTotalElements());
	}
	
	
	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
