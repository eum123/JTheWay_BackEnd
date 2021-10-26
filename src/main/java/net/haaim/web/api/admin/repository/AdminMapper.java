package net.haaim.web.api.admin.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.admin.entity.DailyClassInfoEntity;
import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;

@Mapper
public interface AdminMapper {
	/**
	 * admin 메인에 일별 [클래스 / 출석/ 온라인테스트 / 패스비율 / 평균점수]
	 * @return
	 */
	List<DailyClassInfoEntity> dailyClassInfoList();
	
	/**
	 * 월별 출석 현황.
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<MonthlyAttendanceStatusEntity>  findMonthlyAttendanceStatus(
			@Param("startDate") String  startDate
			, @Param("endDate") String endDate);
}
