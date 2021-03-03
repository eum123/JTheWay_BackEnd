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
import net.haaim.web.exam.entity.QuestionDTO;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JExamList;
import net.haaim.web.jooq.entity.tables.JItemPool;

@Repository
public class QuestionRepositoryJOOQ {
	private final DSLContext dslContext;

	public QuestionRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
	}
	
	/**
	 * 사용자별 문제 출제 목록
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> findAllByUserId(String userId, Pageable pageable) {
		
		List<Condition> conditionList = new ArrayList();
		ConditionHelper.addCondition(conditionList, JExamList.EXAM_LIST.USER_ID, userId);
		ConditionHelper.addCondition(conditionList, JExamList.EXAM_LIST.STATE, 1);
		
		List<QuestionDTO> list = dslContext.select(
					JExamList.EXAM_LIST.EXAM_NO,
					JExamList.EXAM_LIST.CLASS_NO,
					JClass.CLASS.YEAR,
					JExamList.EXAM_LIST.GRADE,
					JExamList.EXAM_LIST.COURSE,
					JExamList.EXAM_LIST.LARGE_CATEGORY,
					JExamList.EXAM_LIST.MEDIUM_CATEGORY,
					JExamList.EXAM_LIST.DATE,
					JExamList.EXAM_LIST.COUNT,
					JExamList.EXAM_LIST.STARE,
					JExamList.EXAM_LIST.STARE_SCORE,
					JExamList.EXAM_LIST.STARE_DATE,
					JClass.CLASS.CLASS_NAME
				)
				.from(JExamList.EXAM_LIST)
				.leftJoin(JClass.CLASS).on(JExamList.EXAM_LIST.CLASS_NO.eq(JClass.CLASS.CLASS_NO))
				.where(DSL.and(conditionList))
				.limit(pageable.getPageSize())
				.fetch()
				.into(QuestionDTO.class);
		int totalCount = dslContext.fetchCount(JClass.CLASS);
		
		return new PageImpl<QuestionDTO>(list, pageable, totalCount);
	}
	
}
