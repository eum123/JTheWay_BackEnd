package net.haaim.web.api.student.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.student.service.StudentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentControllerTest.class)
@AutoConfigureMybatis
@ActiveProfiles("local")
@Slf4j
public class StudentControllerTest {
	@Autowired
	MockMvc mvc;

	@MockBean
	private StudentService studentService;

	@BeforeEach
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new StudentController(studentService))
				.addFilters(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}

	@Test
	public void test() throws Exception {

		final ResultActions actions = mvc
				.perform(get("/student/attendance/monthly/1").contentType(MediaType.APPLICATION_JSON)).andDo(print());

	}
}
