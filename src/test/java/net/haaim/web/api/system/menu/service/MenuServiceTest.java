package net.haaim.web.api.system.menu.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.system.menu.entity.MenuEntity;
import net.haaim.web.api.system.menu.entity.MenuResponse;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class MenuServiceTest {

	@Autowired
	private MenuService menuSerivce;
	
	@Test
	public void findAllTest() {
		//데이터 저장
		
				//실행.
				List<MenuResponse> list = menuSerivce.findAll(2, MenuEntity.VIEW);
				System.out.println(list.size());
				System.out.println(list);
				
				//조건 비교.
	}
}
