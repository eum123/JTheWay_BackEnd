package net.haaim.web.api.exam.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.exam.entity.DailyTakeExamStatusEntity;
import net.haaim.web.api.exam.entity.ExamAverageEntity;
import net.haaim.web.api.exam.entity.ExamListEntity;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;

@Mapper
public interface ExamMapper {
	/**
	 * 특정 학생의 시험 목록.
	 * @param studentNo
	 * @return
	 */
	List<ExamListEntity> findAllByStudentNo(@Param("studentNo") Integer studentNo);
	
	/**
	 * 특정 학생의 월별 시험 상태.
	 * @param studentNo
	 * @return
	 */
	MonthlyExamStatusEntity monthlyExamStatus(@Param("studentNo") Integer studentNo);
	
	/**
	 * 주별 클래스 시험 평균.
	 * @param startDate
	 * @return
	 */
	List<ExamAverageEntity> classAverageInWeekly(@Param("start_date") String startDate);
	
	/**
	 * 일자별 시험 응시 현황.
	 * @return
	 */
	List<DailyTakeExamStatusEntity> dailyTakeExamStatus();
}
