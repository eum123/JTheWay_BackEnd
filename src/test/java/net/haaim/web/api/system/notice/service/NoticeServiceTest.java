package net.haaim.web.api.system.notice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.haaim.web.api.common.page.SpringPageHelper;
import net.haaim.web.api.notice.entity.NoticeEntity;
import net.haaim.web.api.notice.service.NoticeService;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class NoticeServiceTest {

	@Autowired
	private NoticeService serivce;
	
	@Test
	public void findAllTest() {
		//데이터 저장
		
				//실행.
				PageHelper.startPage(1, 10);
				Page<NoticeEntity> list = serivce.findAllByStateAndTitleOrContens(NoticeEntity.VIEW, null, null);
				System.out.println(list.size());
				System.out.println(list);
				
				org.springframework.data.domain.Page p = SpringPageHelper.convertSpringPage(list);
				System.out.println("dkdkdkdkdkdkd: " + p);
				System.out.println(p.getSize());
				System.out.println(p.getNumber());
				//조건 비교.
	}
}
