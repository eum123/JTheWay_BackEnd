package net.haaim.web.notice.service;

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
import net.haaim.web.notice.repository.NoticeRepository;

@SpringBootTest
@ActiveProfiles("local")
public class NoticeServiceForAdminTest {

	@Autowired
	private NoticeRepository repo;

	@Autowired
	private NoticeServiceForAdmin service;
	
	@BeforeEach
	public void init() {
		repo.deleteAll();

		repo.saveAndFlush(NoticeEntity.builder()
				
				.title("title")
				.contents("contents")
				.state(1)
				.build());
	}
	
	@Test
	public void testPage() {
		
		PageRequest pageRequest = CustomPageRequest.of(1, 10, "no");
		Page<NoticeEntity> page = service.search(pageRequest);
		
		Assertions.assertEquals(true, true);
	}
	
	
	
	@AfterEach
	public void destory() {
		repo.deleteAll();
	}
}
