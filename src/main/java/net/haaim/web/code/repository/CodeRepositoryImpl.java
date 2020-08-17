package net.haaim.web.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.entity.QCodeEntity;

public class CodeRepositoryImpl extends QuerydslRepositorySupport implements CodeRepositoryCustom {
	
	public CodeRepositoryImpl() {
		super(CodeEntity.class);
	}

	public List<CodeEntity> findAllByGroupCode(String groupCode) {
		return from(QCodeEntity.codeEntity).where(QCodeEntity.codeEntity.groupCode.eq(groupCode))
				.orderBy(QCodeEntity.codeEntity.codeName.desc()).fetch();

	}

	public List<CodeEntity> findAllByGroupCodeAndUsage(String groupCode, int usage) {
		return from(QCodeEntity.codeEntity)
				.where(QCodeEntity.codeEntity.groupCode.eq(groupCode).and(QCodeEntity.codeEntity.usage.eq(usage)))
				.orderBy(QCodeEntity.codeEntity.codeName.desc()).fetch();
	}
}
