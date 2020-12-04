package net.haaim.web.clazz.service;

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

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.clazz.entity.ClazzDTO;
import net.haaim.web.clazz.entity.ClazzEntity;
import net.haaim.web.clazz.entity.CurriculumEntity;
import net.haaim.web.clazz.repository.ClazzRepository;
import net.haaim.web.clazz.repository.ClazzRepositoryJOOQ;
import net.haaim.web.clazz.repository.CurriculumRepository;
import net.haaim.web.common.Role;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.user.entity.UserEntity;
import net.haaim.web.user.repository.UserRepository;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
public class ClazzServiceTest {

	@Autowired
	private ClazzRepositoryJOOQ repo;
	
	@Autowired
	private ClazzRepository classRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CurriculumRepository curriculumRepo;

	@Autowired
	private ClazzService service;

	private UserEntity userEntity;
	private CurriculumEntity curriculumEntity;
	private ClazzEntity clazzEntity;
	
	@BeforeEach
	public void init() {
		userEntity = userRepo.save(UserEntity.builder()
				.email("email")
				.inputDate(new Date())
				.inputId("id")
				.mobile("mobile")
				.name("name")
				.state(1)
				.usage(1)
				.userId("userId")
				.userType(Role.TEACHER.getCode())
				.userPassword("userPassword")
				.build());
		
		curriculumEntity = curriculumRepo.save(CurriculumEntity.builder()
			.course(1)
			.grade(1)
			.inputDate(new Date())
			.inputId("id")
			.largeCategory("large")
			.mediumCategory("medium")
			.year(2020)
			.build());
		
		clazzEntity = classRepo.save(ClazzEntity.builder()
			.className("className")
			.course(1)
			.curriclumNo(curriculumEntity.getNo())
			.dayTime("dayTime")
			.inputDate(new Date())
			.inputId("id")
			.description("description")
			.endDate("end")
			.startDate("start")
			.passScore(10)
			.teacherNo(userEntity.getNo())
			.textBook("textBook")
			.year(2020)
			.build());
	}
	
	@Test
	public void testSecarchGroupCode() {
		PageRequest pageable = CustomPageRequest.of(0, 10, "classNo");
		
		Page<ClazzDTO> list = service.search(pageable);
		
		System.out.println(list.getContent());
		
		Assertions.assertNotEquals(0, list.getContent().size());
		
		ClazzDTO dto = list.getContent().get(0);
		
		System.out.println("---------------" + dto.getName());
		System.out.println("total---------------" + list.getTotalElements());
		
		Assertions.assertNotNull(list);
		
		
	}

	@AfterEach
	public void destory() {
	
		classRepo.delete(clazzEntity);
		userRepo.delete(userEntity);
		curriculumRepo.delete(curriculumEntity);
	}
}
