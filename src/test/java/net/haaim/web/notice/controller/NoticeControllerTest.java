package net.haaim.web.notice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import net.haaim.web.HaaimWebApplication;
import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.notice.repository.NoticeRepository;
import net.haaim.web.notice.service.NoticeServiceForAdmin;

@SpringBootTest(classes = HaaimWebApplication.class)	
@ActiveProfiles("local")
@AutoConfigureMockMvc
public class NoticeControllerTest {
	@Autowired
    MockMvc mockMvc;
	
	@Mock
	private NoticeRepository repo;
	
	@InjectMocks
    private NoticeServiceForAdmin service;
	
	@BeforeEach
	public void init() {
		repo.deleteAll();
		
		repo.saveAndFlush(NoticeEntity.builder().title("title")
				.contents("contents")
				.state(1)
				.build());
	}

    @Test
    public void hello() throws Exception {
        mockMvc.perform(get("/notice/searchAll").param("page", "1").param("size", "10"))
                .andExpect(status().isOk())
                //.andExpect(content().string("hello saelobi"))
                .andDo(print());
    }
    
    @AfterEach
    public void destory() {
    	repo.deleteAll();
    }

}
