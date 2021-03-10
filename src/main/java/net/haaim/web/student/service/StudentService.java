package net.haaim.web.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.student.entity.MonthlyAttendanceDTO;
import net.haaim.web.student.repository.MonthlyAttendanceRepositoryJOOQ;
import net.haaim.web.student.repository.StudentRepository;
import net.haaim.web.user.entity.UserEntity;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private MonthlyAttendanceRepositoryJOOQ monthlyAttendanceRepo;
	
	public Page<UserEntity> search(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	//TODO:
	public Page<UserEntity> search(String title, String contents, int usage, PageRequest pageable) {

		int useYn = 0;
//		if (usage == null) {
//			useYn = CodeEntity.VIEW;
//		} else {
//			useYn = usage.intValue();
//		}
		
		return repo.findAllByTitleAndContents(title, contents, usage, pageable);

	}
	
	public UserEntity save(UserEntity userEntity) {
		return null;
	}
	
	/**
	 * 월별 출석 현황
	 * @param year
	 * @param month
	 * @param studentNo
	 * @return
	 */
	public MonthlyAttendanceDTO monthlyAttendance(Integer year, Integer month, Integer studentNo) {
		return monthlyAttendanceRepo.findMonthlyAttendance(year, month, studentNo);
	}
	
	public void monthlySchedule(Integer year, Integer month, Integer studentNo) {
		//TODO : 월별 학생 수업
		
		//TODO : 수업별 출/결 현황
		
		//TODO : 온라인 테스트 현황
	}
}
