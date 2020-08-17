package net.haaim.web.code.repository;

import java.util.List;

import net.haaim.web.code.entity.CodeEntity;

public interface CodeRepositoryCustom {
	public List<CodeEntity> findAllByGroupCode(String groupCode);
	
	public List<CodeEntity> findAllByGroupCodeAndUsage(String groupCode, int usage);
}
