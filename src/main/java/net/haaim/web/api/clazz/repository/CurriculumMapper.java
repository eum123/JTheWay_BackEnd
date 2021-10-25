package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

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
}

