package net.haaim.web.code.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.haaim.web.code.entity.CodeEntity;

public interface CodeRepositoryCustom {
	public Page<CodeEntity> findAllGroupCodeOrCodeName(String name, int usage, PageRequest pageable);
	
}
