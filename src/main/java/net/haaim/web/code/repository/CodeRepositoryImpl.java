package net.haaim.web.code.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.entity.QCodeEntity;

public class CodeRepositoryImpl extends QuerydslRepositorySupport implements CodeRepositoryCustom {

	public CodeRepositoryImpl() {
		super(CodeEntity.class);
	}

	public Page<CodeEntity> findAllGroupCodeOrCodeName(String name, int usage, PageRequest pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QCodeEntity.codeEntity.usage.eq(usage));
		
		if(name != null && !name.equals("")) {
			builder.and(QCodeEntity.codeEntity.groupCode.like(name).or(QCodeEntity.codeEntity.codeName.like(name)));
		}
		
		QueryResults<CodeEntity> result = from(QCodeEntity.codeEntity)
				.where(builder	)
				.offset(pageable.getOffset()).limit(pageable.getPageSize())
				.orderBy(QCodeEntity.codeEntity.codeName.desc()).fetchResults();

		return new PageImpl<CodeEntity>(result.getResults(), pageable, result.getTotal());
	}
}
