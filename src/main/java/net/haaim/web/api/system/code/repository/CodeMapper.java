package net.haaim.web.api.system.code.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.system.code.entity.CodeEntity;

@Mapper
public interface CodeMapper {
	/**
	 * code 저장.
	 * @param entity
	 */
	void save(CodeEntity entity);
	
	/**
	 * 코드 조회.
	 * @param useYn
	 * @return
	 */
	List<CodeEntity> findAllByUseYn(@Param("use_yn") Integer useYn);
	
	
}
