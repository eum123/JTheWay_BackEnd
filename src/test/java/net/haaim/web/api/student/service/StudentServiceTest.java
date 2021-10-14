package net.haaim.web.api.student.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;

@SpringBootTest
//@Sql(scripts = {"file:src/main/resources/product.sql"})
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@ActiveProfiles("local")
//@MapperScan(basePackages = "net.haaim.web.api.student")
public class StudentServiceTest {

	@Autowired
	private StudentService service;
	
	@Test
	public void monthlyAttendanceTest() {
		List<MonthlyAttendanceStatusEntity> list = service.monthlyAttendanceStatus(1, null, null);
		System.out.println(list.size());
	}
}
