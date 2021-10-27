package net.haaim.web.api.system.code.service;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.system.code.entity.CodeGroupEntity;
import net.haaim.web.api.system.code.repository.CodeGroupMapper;

@RequiredArgsConstructor
@Service
public class CodeGroupService {
	private final CodeGroupMapper mapper;
	
	/**
	 * code group 저장.
	 * @param entity
	 * @return
	 */
	public CodeGroupEntity save(CodeGroupEntity entity) {
		mapper.save(entity);
		return entity;
	}
	
	/**
	 * code group 조회.
	 * @param useYn
	 * @return
	 */
	public List<CodeGroupEntity> findAllByUseYn(Integer useYn) {
		return mapper.findAllByUseYn(useYn);
	}
}
