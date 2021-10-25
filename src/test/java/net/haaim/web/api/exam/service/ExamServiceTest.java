package net.haaim.web.api.exam.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.haaim.web.api.exam.entity.DailyTakeExamStatusEntity;
import net.haaim.web.api.exam.entity.ExamAverageEntity;
import net.haaim.web.api.exam.entity.ItemPoolEntity;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
public class ExamServiceTest {

	@Autowired
	private ExamService service;
	
	@Test
	public void findAllByStudentNoTest() {
		//데이터 저장
		
		//실행.
		List<ItemPoolEntity> list = service.findAllByStudentNo(1);
		System.out.println(list.size());
		System.out.println(list);
		
		//조건 비교.
	}
	
	@Test
	public void findAllByStudentNoPageTest() {
		//데이터 저장
		
		PageHelper.startPage(1, 5);
		
		//실행.
		List<ItemPoolEntity> list = service.findAllByStudentNo(1);
		System.out.println(list.size());
		System.out.println(list);
		
		PageInfo info = PageInfo.of(list);
		
		System.out.println(info);
		
		//조건 비교.
	}
	
	@Test
	public void monthlyExamStatusTest() {
		//데이터 저장
		
		//실행.
		MonthlyExamStatusEntity entity = service.monthlyExamStatus(1);
		System.out.println(entity);
		
		//조건 비교.
	}
	
	@Test
	public void classAverageInWeeklyTest() {
		List<ExamAverageEntity> list = service.classAverageInWeekly();
		System.out.println(list);
	}
	
	@Test
	public void dailyTakeExamStatusTest() {
		List<DailyTakeExamStatusEntity> list = service.dailyTakeExamStatus();
		System.out.println(list);
	}
}
