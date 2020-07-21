package net.haaim.web.notice.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import net.haaim.web.notice.repository.NoticeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class NoticeServiceTest {

	@Autowired
	private NoticeRepository repo;

	@Autowired
	private NoticeService service;
}
