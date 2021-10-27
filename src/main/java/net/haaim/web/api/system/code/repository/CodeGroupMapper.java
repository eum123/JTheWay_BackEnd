package net.haaim.web.api.system.code.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.system.code.entity.CodeGroupEntity;

@Mapper
public interface CodeGroupMapper {
	/**
	 * code group 저장.
	 * @param entity
	 */
	@Insert("INSERT INTO code_group (code, code_name, use_yn, input_id, input_date) "
			+ "VALUES (#{code}, #{codeName}, #{useYn}, #{inputId}, NOW()) ")
	void save(CodeGroupEntity entity);
	
	/**
	 * code group 조회.
	 * @param useYn
	 * @return
	 */
	List<CodeGroupEntity> findAllByUseYn(@Param("use_yn") Integer useYn);
}
