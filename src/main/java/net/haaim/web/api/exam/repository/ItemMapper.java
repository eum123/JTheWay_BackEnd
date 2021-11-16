package net.haaim.web.api.exam.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.exam.entity.ItemPoolEntity;

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
	Page<ItemPoolEntity> findAllByGradeOrCourseOrMediumCategoryOrUserYnOrQuestion(
			@Param("year") Integer year, 
			@Param("grade") Integer grade, 
			@Param("course") Integer course, 
			@Param("medium_category") String mediumCategory,
			@Param("use_yn") Integer useYn,
			@Param("question") String question);
}
