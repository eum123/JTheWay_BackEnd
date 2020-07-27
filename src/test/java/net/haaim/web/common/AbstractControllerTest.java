package net.haaim.web.common;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class AbstractControllerTest {
	@Autowired
	//protected WebApplicationContext wac;
	protected MockMvc mockMvc;

	@BeforeEach
	public void initMockMvc() {
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
}
