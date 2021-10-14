package net.haaim.web.api.student.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;

@Mapper
public interface StudentMapper {
	List<MonthlyAttendanceStatusEntity>  findMonthlyAttendanceStatus(
			@Param("studentNo") Integer studentNo
			, @Param("startDate") String  startDate
			, @Param("endDate") String endDate);
}
