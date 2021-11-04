package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import net.haaim.web.api.clazz.entity.CurriculumEntity;

@Mapper
public interface CurriculumMapper {
	
	@Insert("INSERT INTO curriculum (year, grade, course, large_category "
			+ ", medium_category, input_id , input_date) "
			+ "VALUES (#{year}, #{grade}, #{course}"
			+ ", #{largeCategory}, #{mediumCategory}"
			+ ", #{inputId}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "cno")
	Integer save(CurriculumEntity entity);
	
	/**
	 * 
	 * @param year
	 * @param grade
	 * @param course
	 * @param largeCategory
	 * @param mediumCategory
	 * @return
	 */
	Page<CurriculumEntity> findAllByYearAndGradeAndCourseAndLargeCategoryAndMediumCateogry(Integer year, String grade, String course, String largeCategory,
			String mediumCategory);
	
	/**
	 * 커리큘럼 한건 조회.
	 * @param classNo class_no
	 * @return
	 */
	@Select("SELECT a.cno, a.year, a.grade, a.course, a.large_category, "
			+ "	a.medium_category, a.input_id, a.input_date, a.update_id, a.update_date  "
			+ "FROM curriculum a "
			+ "		JOIN class_curriculum b on a.cno = b.cur_id "
			+ "WHERE b.class_no = #{class_no} "
			+ "LIMIT 1 ")
	CurriculumEntity findTopOneByClassNo(@Param("class_no") Integer classNo) ;
}

