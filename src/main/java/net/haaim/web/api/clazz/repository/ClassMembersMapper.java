package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import net.haaim.web.api.clazz.entity.ClassMembersEntity;

@Mapper
public interface ClassMembersMapper {
	
	@Insert("INSERT INTO class_members (class_no, member_type, member_no, status, "
			+ ", input_id, input_date) "
			+ "VALUES (#{classNo}, #{memberType}, #{memberNo}, #{status}, "
			+ ", #{inputId}, NOW())")
	Integer save(ClassMembersEntity entity);
	
	
}
