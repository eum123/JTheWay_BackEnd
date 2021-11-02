package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import net.haaim.web.api.clazz.entity.ClassCurriculumEntity;

@Mapper
public interface ClassCurriculumMapper {
	
	@Insert("INSERT INTO class_curriculum (class_no, cur_id, type_group, cdate, "
			+ "ctime, status, input_id, input_date) "
			+ "VALUES (#{classNo}, #{curId}, #{typeGroup}"
			+ ", #{cDate}, #{cTime}, #{status}"
			+ ", #{inputId}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "no")
	Integer save(ClassCurriculumEntity entity);
	
	
}
