package net.haaim.web.member.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.HaaimWebApplication;
import net.haaim.web.common.AbstractControllerTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HaaimWebApplication.class)
@ActiveProfiles("local")
@Slf4j
public class MemberControllerTest extends AbstractControllerTest{
	
	@Test
	public void singin() throws Exception {
		mockMvc.perform(post("/member/signin").param("name", "hong").param("password", "passwd"))
		.andDo(print())
		.andExpect(status().isOk())
		;
	}
	
	
	@Test
	public void auth() throws Exception {
		MvcResult result = mockMvc.perform(post("/member/signin").param("name", "hong").param("password", "passwd"))
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn()
		;
		
		String authorization = result.getRequest().getHeader("Authorization");
		
		log.debug(authorization);
		
		mockMvc.perform(post("/member/sample").header("Authorization", authorization))
		.andDo(print())
		.andExpect(status().isOk())
		;
		
		
	
		
	}
	
	
}
