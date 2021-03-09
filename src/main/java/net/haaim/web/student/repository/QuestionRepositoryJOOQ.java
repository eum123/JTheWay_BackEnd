package net.haaim.web.student.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.DateHelper;
import net.haaim.web.common.query.ConditionHelper;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JExamItem;
import net.haaim.web.jooq.entity.tables.JExamList;
import net.haaim.web.jooq.entity.tables.JExamUser;
import net.haaim.web.student.entity.ExamItemDTO;
import net.haaim.web.student.entity.ExamNowCountDTO;
import net.haaim.web.student.entity.QuestionDTO;

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
//				JExamList.EXAM_LIST.STARE,
//				JExamList.EXAM_LIST.STARE_SCORE,
//				JExamList.EXAM_LIST.STARE_DATE,
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
	public Page<QuestionDTO> findAllByUserId(Integer classNo, Integer studentNo, Pageable pageable) {
		
		List<Condition> conditionList = new ArrayList();
		ConditionHelper.addCondition(conditionList, JExamUser.EXAM_USER.STUDENT_NO, studentNo);
		ConditionHelper.addCondition(conditionList, JExamList.EXAM_LIST.STATE, 1);
		ConditionHelper.addCondition(conditionList, JClass.CLASS.CLASS_NO, classNo);
		
		
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
				JExamUser.EXAM_USER.STATUS,
				JExamUser.EXAM_USER.SCORE,
				JClass.CLASS.CLASS_NAME
			)
			.from(JExamList.EXAM_LIST)
			.leftJoin(JClass.CLASS).on(JExamList.EXAM_LIST.CLASS_NO.eq(JClass.CLASS.CLASS_NO))
			.leftJoin(JExamUser.EXAM_USER).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
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
	 * @param status	응시여부(1-응시, 0-미응시)
	 * @param classNo
	 * @param studentNo
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> findAllByYearAndStareAndUserId(Integer year, Integer status, Integer classNo, Integer studentNo, Pageable pageable) {
		List<Condition> andConditionList = new ArrayList();
		ConditionHelper.addCondition(andConditionList, JExamUser.EXAM_USER.STUDENT_NO, studentNo);
		ConditionHelper.addCondition(andConditionList, JExamList.EXAM_LIST.STATE, 1);
		
		List<Condition> orConditionList = new ArrayList();
		ConditionHelper.addCondition(orConditionList, JExamList.EXAM_LIST.DATE, year);
		ConditionHelper.addCondition(orConditionList, JExamUser.EXAM_USER.STATUS, status);
		
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
				JExamUser.EXAM_USER.STATUS,
				JExamUser.EXAM_USER.SCORE,
				JClass.CLASS.CLASS_NAME
			)
			.from(JExamList.EXAM_LIST)
			.leftJoin(JClass.CLASS).on(JExamList.EXAM_LIST.CLASS_NO.eq(JClass.CLASS.CLASS_NO))
			.leftJoin(JExamUser.EXAM_USER).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
			.where(DSL.and(andConditionList).or(DSL.or(orConditionList)));
		
		//list
		List<QuestionDTO> list = query.limit(pageable.getPageSize())
				.fetch()
				.into(QuestionDTO.class);
		
		//전체 건수
		int totalCount = dslContext.fetchCount(query);
		
		return new PageImpl<QuestionDTO>(list, pageable, totalCount);
	}
	
	/**
	 * 학생별 문제 목록
	 * @param examNo
	 * @return
	 */
	public List<ExamItemDTO> findAllByExamNo(Integer examNo) {
		return dslContext.select(
			JExamItem.EXAM_ITEM.NO,
			JExamItem.EXAM_ITEM.EXAM_NO,
			JExamItem.EXAM_ITEM.ITEM_NO,
			JExamItem.EXAM_ITEM.QUESTION_TYPE,
			JExamItem.EXAM_ITEM.QUESTION,
			JExamItem.EXAM_ITEM.CHOICE1,
			JExamItem.EXAM_ITEM.CHOICE2,
			JExamItem.EXAM_ITEM.CHOICE3,
			JExamItem.EXAM_ITEM.CHOICE4,
			JExamItem.EXAM_ITEM.CHOICE5,
			JExamItem.EXAM_ITEM.FILE_PATH,
			JExamItem.EXAM_ITEM.MARK_TYPE,
			JExamItem.EXAM_ITEM.ANSWER,
			JExamItem.EXAM_ITEM.ANSWER_PATH
		)
		.from(JExamItem.EXAM_ITEM)
		.where(JExamItem.EXAM_ITEM.EXAM_NO.eq(examNo))
		.orderBy(JExamItem.EXAM_ITEM.NO.asc())
		.fetch()
		.into(ExamItemDTO.class);
	}
	
	/**
	 * 현재 미 진행한 온라인 테스트 건수를 추출한다. 
	 * @param studentNo
	 * @return
	 */
	public ExamNowCountDTO findExamNowCount(Integer studentNo) {
		String nowDateString = DateHelper.toNowString();
		
		int nowCount = dslContext.selectCount()
		.from(JExamList.EXAM_LIST)
		.leftJoin(JExamUser.EXAM_USER).on(JExamList.EXAM_LIST.EXAM_NO.eq(JExamUser.EXAM_USER.EXAM_NO))
		.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
				.and(JExamList.EXAM_LIST.SDATE.lessThan(nowDateString))
				.and(JExamList.EXAM_LIST.EDATE.greaterThan(nowDateString))
				.and(JExamUser.EXAM_USER.STATUS.eq(0)))	//TODO : 미진행 코드 확인
		.fetchOne(0, int.class);
		
		return ExamNowCountDTO.builder()
				.count(nowCount)
				.build();
	}
}
