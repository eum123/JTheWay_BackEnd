package net.haaim.web.api.clazz.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.clazz.entity.ProgressListResponse;

@Mapper
public interface ProgressMapper {
	
	
	
	/**
	 * class 목록.
	 * @return
	 */
	
	Page<ProgressListResponse> findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(
			@Param("year") Integer year, 
			@Param("grade") Integer grade, 
			@Param("class_name") String className, 
			@Param("member_id") String memberId, 
			@Param("u_type") Integer uType, 
			@Param("id") String ownerId );
}
