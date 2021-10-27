package net.haaim.web.api.student.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;
import net.haaim.web.api.student.entity.StudentListResponse;

@Mapper
public interface StudentMapper {
	List<MonthlyAttendanceStatusEntity> findMonthlyAttendanceStatus(@Param("studentNo") Integer studentNo,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 학생 목록 조회.
	 * @param year
	 * @param classNo
	 * @param keyword
	 * @return
	 */
	Page<StudentListResponse> findAllByYearAnyClassNoAndKeyword(Integer year, Integer classNo, String keyword);
}
