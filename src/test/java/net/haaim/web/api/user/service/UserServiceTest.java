package net.haaim.web.api.user.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.user.entity.UserEntity;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class UserServiceTest {

	@Autowired
	private CustomUserDetailService service;
	
	@Test
	public void findAllByUType() {
		//데이터 저장
		
		//조건 비교.
		List<UserEntity> list = service.findAllByUType(1);
		System.out.println(list);
	}
}
