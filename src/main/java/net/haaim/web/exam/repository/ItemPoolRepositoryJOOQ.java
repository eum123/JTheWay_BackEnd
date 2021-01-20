package net.haaim.web.exam.repository;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import net.haaim.web.common.query.ConditionHelper;
import net.haaim.web.exam.entity.ItemPoolEntity;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JItemPool;

@Repository
public class ItemPoolRepositoryJOOQ {
	private final DSLContext dslContext;

	public ItemPoolRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
	}
	
	public Page<ItemPoolEntity> findAll(Pageable pageable) {
		List<ItemPoolEntity> list = dslContext.select()
				.from(JItemPool.ITEM_POOL)
				.orderBy(JItemPool.ITEM_POOL.ITEM_NO.desc())
				.offset((int)pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch()
				.into(ItemPoolEntity.class);
			
			int totalCount = dslContext.fetchCount(JClass.CLASS);
			
			return new PageImpl<ItemPoolEntity>(list, pageable, totalCount);
	}
	
	public Page<ItemPoolEntity> findAllByCondition(Integer year, Integer grade, Integer course, String mediumCategory, Integer useYn, String question, Pageable pageable) {
		
		List<Condition> conditionList = new ArrayList();
		
		ConditionHelper.addCondition(conditionList, JItemPool.ITEM_POOL.YEAR, year);
		ConditionHelper.addCondition(conditionList, JItemPool.ITEM_POOL.GRADE, grade);
		ConditionHelper.addCondition(conditionList, JItemPool.ITEM_POOL.COURSE, course);
		ConditionHelper.addCondition(conditionList, JItemPool.ITEM_POOL.MEDIUM_CATEGORY, mediumCategory);
		ConditionHelper.addCondition(conditionList, JItemPool.ITEM_POOL.USE_YN, useYn);
		ConditionHelper.addLikeCondition(conditionList, JItemPool.ITEM_POOL.QUESTION, question);
		
		List<ItemPoolEntity> list = dslContext.select()
			.from(JItemPool.ITEM_POOL)
			.where(DSL.or(conditionList))
			.orderBy(JItemPool.ITEM_POOL.ITEM_NO.desc())
			.offset((int)pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch()
			.into(ItemPoolEntity.class);
		
		int totalCount = dslContext.fetchCount(JClass.CLASS);
		
		return new PageImpl<ItemPoolEntity>(list, pageable, totalCount);
		
	}
	
	

}
