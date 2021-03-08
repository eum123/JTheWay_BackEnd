package net.haaim.web.exam.service;

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
import net.haaim.web.clazz.entity.ClassEntity;
import net.haaim.web.clazz.repository.ClazzRepository;
import net.haaim.web.common.Role;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.exam.entity.QuestionDTO;
import net.haaim.web.exam.entity.QuestionEntity;
import net.haaim.web.exam.repository.QuestionRepository;
import net.haaim.web.user.entity.UserEntity;
import net.haaim.web.user.repository.UserRepository;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
public class QuestionServiceTest {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private ClazzRepository classRepository;
	
	@Autowired
	private QuestionService service;
	
	private UserEntity userEntity;
	private ClassEntity clazzEntity;
	private QuestionEntity questionEntity;
	
	@BeforeEach
	private void init() {
		userEntity = userRepo.save(UserEntity.builder()
				.email("email")
				.inputDate(new Date())
				.inputId("id")
				.mobile("mobile")
				.name("name")
				.state(1)
				.usage(1)
				.userId("id")
				.userType(Role.TEACHER.getCode())
				.userPassword("userPassword")
				.build());
		
		
		clazzEntity = classRepository.save(ClassEntity.builder()
			.className("className")
			.course(1)
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
		
		questionEntity = questionRepository.save(questionEntity.builder()
				.userId("id")
				.date("20210301")
				.classNo(clazzEntity.getClassNo())
				.grade(1)
				.count(1)
				.largeCategory("large")
				.mediumCategory("medium")
				.typeGroup("type")
				.count(1)
				.levelDifficulty(1)
				.target("target")
				.goalScore(10)
				.state(1)
				.stare(1)
				.stareDate(new Date())
				.stareScore(1)
				.inputDate(new Date())
				.inputId("id")
				.build());
		
	}
	
	@Test
	public void testService() {
		
		PageRequest pageable = CustomPageRequest.of(1, 10, "exam_no");
		Page<QuestionDTO> dto = service.search(1, 1, pageable);
		
		Assertions.assertEquals(1, dto.getContent().size());
		
	}
	
	@Test
	public void testNullId() {
		
		PageRequest pageable = CustomPageRequest.of(1, 10, "exam_no");
		Page<QuestionDTO> dto = service.search(1, null, pageable);
		
		Assertions.assertEquals(1, dto.getContent().size());
		
	}
	
	@AfterEach
	private void clear() {
		questionRepository.delete(questionEntity);
		classRepository.delete(clazzEntity);
		userRepo.delete(userEntity);
	}
}
