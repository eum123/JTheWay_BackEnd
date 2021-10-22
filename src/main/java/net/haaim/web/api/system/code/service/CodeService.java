package net.haaim.web.api.system.code.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.system.code.entity.CodeEntity;
import net.haaim.web.api.system.code.repository.CodeMapper;

@RequiredArgsConstructor
@Service
public class CodeService {
	private final CodeMapper mapper;
	
	/**
	 * code 저장.
	 * @param entity
	 * @return
	 */
	public CodeEntity save(CodeEntity entity) {
		mapper.save(entity);
		return entity;
	}
	
	/**
	 * code 조회.
	 * @param useYn
	 * @return
	 */
	public List<CodeEntity> findAllByUseYn(Integer useYn) {
		return mapper.findAllByUseYn(useYn);
	}
}
