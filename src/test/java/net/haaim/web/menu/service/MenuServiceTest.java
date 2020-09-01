package net.haaim.web.menu.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import net.haaim.web.authority.repository.AuthorityRepository;
import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.repository.MenuRepository;

@SpringBootTest
@ActiveProfiles("local")
public class MenuServiceTest {
	
	@Autowired
	private MenuRepository repo;
	
	@Autowired
	private AuthorityRepository authRepo;
	
	
	@Autowired
	private MenuServiceForAdmin service;
	
	@BeforeEach
	public void init() {
		
	}
	
	@Test
	public void testService() {
		List<MenuEntity> list = service.search(Role.TEACHER, 1);
	}
}
