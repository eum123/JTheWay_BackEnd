package net.haaim.web.student.repository;

import java.util.ArrayList;
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
import net.haaim.web.common.query.ConditionHelper;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JExamItem;
import net.haaim.web.jooq.entity.tables.JExamList;
import net.haaim.web.jooq.entity.tables.JExamUser;
import net.haaim.web.student.entity.QuestionDTO;
import net.haaim.web.student.entity.ExamItemDTO;

@Slf4j
@Repository
public class QuestionItemRepositoryJOOQ {
	private final DSLContext dslContext;

	public QuestionItemRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
		this.dslContext.settings().setStatementType(StatementType.PREPARED_STATEMENT);
		
	}
	
	/**
	 * 출제번호에 맞는 온라인테스트 문제 목록 조회 
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public List<ExamItemDTO> findByExamNoAndStudentNo(Integer examNo, Integer studentNo) {
		return dslContext.select(
				JExamItem.EXAM_ITEM.EXAM_NO,
				JExamItem.EXAM_ITEM.NO,
				JExamItem.EXAM_ITEM.ITEM_NO,
				JExamItem.EXAM_ITEM.QUESTION_TYPE,
				JExamItem.EXAM_ITEM.QUESTION,
				JExamItem.EXAM_ITEM.CHOICE1,
				JExamItem.EXAM_ITEM.CHOICE2,
				JExamItem.EXAM_ITEM.CHOICE3,
				JExamItem.EXAM_ITEM.CHOICE4,
				JExamItem.EXAM_ITEM.CHOICE5,
				JExamItem.EXAM_ITEM.FILE_PATH,
				JExamItem.EXAM_ITEM.MARK_TYPE
			)
			.from(JExamItem.EXAM_ITEM)
			.leftJoin(JExamUser.EXAM_USER).on(JExamItem.EXAM_ITEM.EXAM_NO.eq(JExamUser.EXAM_USER.EXAM_NO))
			.where(JExamItem.EXAM_ITEM.EXAM_NO.eq(examNo)
					.and(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)))
			.fetch()
			.into(ExamItemDTO.class);
	}
	
	
}
