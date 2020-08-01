package net.haaim.web.notice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import net.haaim.web.common.Role;
import net.haaim.web.common.User;

@SpringBootTest
@ActiveProfiles("local")
public class NoticeFactoryTest {
	
	@Autowired
	private NoticeServiceFactory factory;
	
	@Test
	public void testInstance() {
		User studentUser = new User("id", Role.STUDENT);
		
		NoticeService service = factory.getInstance(studentUser);
		
		System.out.println(service);
		
		Assertions.assertTrue(service instanceof NoticeServiceForStudent);
	}
	
	@Test
	public void testAdminInstance() {
		User studentUser = new User("id", Role.TEACHER);
		
		NoticeService service = factory.getInstance(studentUser);
		
		System.out.println(service);
		
		Assertions.assertTrue(service instanceof NoticeServiceForAdmin);
	}
}
