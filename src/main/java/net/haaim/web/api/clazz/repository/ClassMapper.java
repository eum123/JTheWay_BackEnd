package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import net.haaim.web.api.clazz.entity.ClassEntity;

@Mapper
public interface ClassMapper {
	
	@Insert("INSERT INTO class (year, class_name, start_date, end_date, day_time"
			+ ", textbook, pass_score, description, status, input_id"
			+ ", input_date) "
			+ "VALUES (#{entity.year}, #{entity.class_name}, #{entity.start_date}"
			+ ", #{entity.end_date}, #{entity.day_time}, #{entity.textbook}"
			+ ", #{entity.pass_score}, #{entity.description}, #{entity.status}"
			+ ", #{entity.input_id}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "class_no")
	Integer save(ClassEntity entity);
}
