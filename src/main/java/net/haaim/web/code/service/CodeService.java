package net.haaim.web.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.repository.CodeRepository;

@Service
public class CodeService {
	@Autowired
	private CodeRepository repo;
	
	public List<CodeEntity> search(String groupCode) {
		return repo.findAllByGroupCode(groupCode);
	}
	
	public List<CodeEntity> search(String groupCode, int usage) {
		return repo.findAllByGroupCodeAndUsage(groupCode, usage);
	}
}
