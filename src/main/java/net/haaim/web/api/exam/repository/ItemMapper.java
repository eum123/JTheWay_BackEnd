package net.haaim.web.api.exam.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.exam.entity.DailyTakeExamStatusEntity;
import net.haaim.web.api.exam.entity.ExamAverageEntity;
import net.haaim.web.api.exam.entity.ItemPoolEntity;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;

@Mapper
public interface ItemMapper {
	/**
	 * 문제 은행 목록 조회.
	 * @param year
	 * @param grade
	 * @param course
	 * @param mediumCategory
	 * @param useYn
	 * @param question
	 * @return
	 */
	List<ItemPoolEntity> findAllByGradeOrCourseOrMediumCategoryOrUserYnOrQuestion(
			@Param("year") Integer year, 
			@Param("grade") Integer grade, 
			@Param("course") Integer course, 
			@Param("medium_category") String mediumCategory,
			@Param("use_yn") Integer useYn,
			@Param("question") String question);
}
