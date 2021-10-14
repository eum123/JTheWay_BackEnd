package net.haaim.web.api.exam.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
