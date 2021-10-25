package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import net.haaim.web.api.clazz.entity.CurriculumEntity;

@Mapper
public interface CurriculumMapper {
	
	@Insert("INSERT INTO curriculum (year, grade, course, large_category "
			+ ", medium_category, input_id , input_date) "
			+ "VALUES (#{entity.year}, #{entity.grade}, #{entity.course}"
			+ ", #{entity.large_category}, #{entity.medium_category}"
			+ ", #{entity.input_id}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "cno")
	Integer save(CurriculumEntity entity);
}
