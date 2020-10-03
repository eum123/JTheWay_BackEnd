package net.haaim.web.menu.service;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.authority.entity.AuthorityEntity;
import net.haaim.web.authority.repository.AuthorityRepository;
import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.repository.MenuRepository;

@Slf4j
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
//		authRepo.deleteAll();
//		repo.deleteAll();
//		
//		authRepo.save(AuthorityEntity.builder().menuCode("11").inputDate(new Date()).inputId("id").usage(1).userType(1)
//				.build());
//		repo.save(MenuEntity.builder().depth(0).inputDate(new Date()).inputId("id").menuCode("11").menuName("11 name")
//				.parentMenuCode("0").url("url").usage(1).build());
//		repo.save(MenuEntity.builder().depth(0).inputDate(new Date()).inputId("id").menuCode("12").menuName("12 name")
//				.parentMenuCode("0").url("url").usage(1).build());
	}

	@Test
	public void testService() {
		List<MenuEntity> list = service.search(Role.TEACHER, 1);
		Assertions.assertEquals(18, list.size());
		
	}
	@Test
	public void testMenuSearch() {
		List<MenuEntity> list = service.search(Role.CODY, 1);
		Assertions.assertEquals(18, list.size());

	}
}
