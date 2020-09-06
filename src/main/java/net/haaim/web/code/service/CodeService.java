package net.haaim.web.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.repository.CodeRepository;

@Service
public class CodeService {
	@Autowired
	private CodeRepository repo;
	
	public Page<CodeEntity> search(PageRequest pageable) {
		return repo.findAll(pageable);
	}
	
	public Page<CodeEntity> search(String groupCode, Integer usage, PageRequest pageable) {
		
		int useYn = 0;
		if (usage == null) {
			useYn = CodeEntity.VIEW;
		} else {
			useYn = usage.intValue();
		}
		
		return repo.findAllGroupCodeOrCodeName(groupCode, useYn, pageable);
	}
}
