package net.haaim.web.api.system.code.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.system.code.entity.CodeEntity;

@Mapper
public interface CodeMapper {
	/**
	 * code 저장.
	 * 
	 * @param entity
	 */
	@Insert("INSERT INTO code (group_code, code, code_name, use_yn, input_id, input_date) "
			+ "VALUES (#{groupCode}, #{code}, #{codeName}, #{useYn}, #{inputId}, NOW())")
	void save(CodeEntity entity);

	/**
	 * 코드 조회.
	 * 
	 * @param codeName
	 * @param useYn
	 * @return
	 */
	Page<CodeEntity> findAllByCodeNameAndUseYn(@Param("code_name") String codeName, @Param("use_yn") Integer useYn);

}
