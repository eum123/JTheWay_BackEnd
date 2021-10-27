package net.haaim.web.api.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.common.util.DateHelper;
import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;
import net.haaim.web.api.student.entity.StudentListResponse;
import net.haaim.web.api.student.repository.StudentMapper;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentMapper studentMapper;

	/**
	 * 월별 출석 현황
	 * 
	 * @param year
	 * @param month
	 * @param studentNo
	 * @return
	 */
	public List<MonthlyAttendanceStatusEntity> monthlyAttendanceStatus(Integer studentNo, Integer baseYear, Integer baseMonth) {

		return studentMapper.findMonthlyAttendanceStatus(studentNo, DateHelper.getStartDate(baseYear, baseMonth),
				DateHelper.getEndDate(baseYear, baseMonth));
	}
	
	/**
	 * 학생 목록 조회.
	 * @param year
	 * @param classNo
	 * @param keyword
	 * @return
	 */
	public Page<StudentListResponse> findAllByYearAnyClassNoAndKeyword(Integer year, Integer classNo, String keyword) {
		return studentMapper.findAllByYearAnyClassNoAndKeyword(year, classNo, keyword);
	}

}
