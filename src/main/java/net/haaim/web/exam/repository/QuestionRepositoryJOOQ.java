package net.haaim.web.exam.repository;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.query.ConditionHelper;
import net.haaim.web.exam.entity.QuestionDTO;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JExamList;

@Slf4j
@Repository
public class QuestionRepositoryJOOQ {
	private final DSLContext dslContext;

	public QuestionRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
		this.dslContext.settings().setStatementType(StatementType.PREPARED_STATEMENT);
		
	}
	
	/**
	 * 출제번호에 맞는 온라인테스트 내용 조회 
	 * @param examNo
	 * @return
	 */
	public QuestionDTO findOneByExamNo(Integer examNo) {
		return dslContext.select(
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
			.where(JExamList.EXAM_LIST.EXAM_NO.eq(examNo))
			.fetchOne()
			.into(QuestionDTO.class);
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
		
		
		SelectConditionStep<?> query = dslContext.select(
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
			.where(DSL.and(conditionList));
		
		//list
		List<QuestionDTO> list = query.limit(pageable.getPageSize())
				.fetch()
				.into(QuestionDTO.class);
		
		//전체 건수
		int totalCount = dslContext.fetchCount(query);
		
		return new PageImpl<QuestionDTO>(list, pageable, totalCount);
	}
	
	/**
	 * 사용자별 조건 검색 
	 * @param year 기간
	 * @param stare	응시여부(1-응시, 0-미응시)
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> findAllByYearAndStareAndUserId(Integer year, Integer stare, String userId, Pageable pageable) {
		List<Condition> andConditionList = new ArrayList();
		ConditionHelper.addCondition(andConditionList, JExamList.EXAM_LIST.USER_ID, userId);
		ConditionHelper.addCondition(andConditionList, JExamList.EXAM_LIST.STATE, 1);
		
		List<Condition> orConditionList = new ArrayList();
		ConditionHelper.addCondition(orConditionList, JClass.CLASS.YEAR, userId);
		ConditionHelper.addCondition(orConditionList, JExamList.EXAM_LIST.STARE, stare);
		
		SelectConditionStep<?> query = dslContext.select(
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
			.where(DSL.and(andConditionList).or(DSL.or(orConditionList)));
		
		//list
		List<QuestionDTO> list = query.limit(pageable.getPageSize())
				.fetch()
				.into(QuestionDTO.class);
		
		//전체 건수
		int totalCount = dslContext.fetchCount(query);
		
		return new PageImpl<QuestionDTO>(list, pageable, totalCount);
	}
	
}
