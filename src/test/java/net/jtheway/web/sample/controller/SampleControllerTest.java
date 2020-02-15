package net.jtheway.web.sample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;
import net.jtheway.web.JTheWayWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JTheWayWebApplication.class)
@ActiveProfiles("local")
@Slf4j
public class SampleControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void sampleSearch() throws Exception {

		HttpHeaders headers = new HttpHeaders();

		mockMvc.perform(get("/sample/search").param("name", "hong"))
			.andDo(print())
			.andExpect(status().isOk())
			;

	}
}

/*
//로그인 testcase
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmsApplication.class)
@ActiveProfiles("local")
@Transactional
public class Auth {

   @Autowired
   private WebApplicationContext wac;
   private MockMvc mockMvc;
   @Autowired
   private Filter springSecurityFilterChain;
   private MockHttpSession session;

   @Before
   public void initMockMvc() throws Exception {
      mockMvc = webAppContextSetup(wac)
            .dispatchOptions(true)
            .addFilters(springSecurityFilterChain)
            .build();

      this.session = (MockHttpSession)mockMvc.perform(formLogin(WebSecurityConfigurerAdapter.LOGIN_PROCESSING_URL)
            .user("****")
            .password("****"))
            .andExpect(status().is3xxRedirection())
            .andReturn().getRequest().getSession();
   }

   @Test
   public void 로그인사용자_정보조회() throws Exception {

      mockMvc.perform(get("/auth/detail")
            .session(session)
            .with(csrf().asHeader()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.admNm").value("김현하"))
            .andDo(MockMvcResultHandlers.print());

   }


   @After
   public void after() throws Exception {
      //mockMvc.perform(logout(WebSecurityConfigurerAdapter.LOGOUT_URL)).andExpect(status().is3xxRedirection());
   }

}

*/
