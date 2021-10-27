package net.haaim.web.api.system.code.service;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.system.code.entity.CodeEntity;
import net.haaim.web.api.system.code.repository.CodeMapper;

@Validated
@RequiredArgsConstructor
@Service
public class CodeService {
	private final CodeMapper mapper;
	
	/**
	 * code 저장.
	 * @param entity
	 * @return
	 */
	public CodeEntity save(@Valid CodeEntity entity) {
		mapper.save(entity);
		return entity;
	}
	
	/**
	 * code 조회.
	 * 
	 * @param codeName
	 * @param useYn
	 * @return
	 */
	public Page<CodeEntity> findAllByCodeNameAndUseYn(String codeName, 
			Integer useYn) {
		return mapper.findAllByCodeNameAndUseYn(codeName, useYn);
	}
}
