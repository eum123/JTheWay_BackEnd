package net.haaim.web.student.repository;

import org.jooq.DSLContext;
import org.jooq.conf.StatementType;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.DateHelper;
import net.haaim.web.jooq.entity.tables.JClassMngt;
import net.haaim.web.jooq.entity.tables.JExamList;
import net.haaim.web.jooq.entity.tables.JExamUser;
import net.haaim.web.student.entity.MonthlyExamDTO;

@Slf4j
@Repository
public class MonthlyExamRepositoryJOOQ {
	private final DSLContext dslContext;

	public MonthlyExamRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
		this.dslContext.settings().setStatementType(StatementType.PREPARED_STATEMENT);
		
	}
	
	/**
	 * 출제번호에 맞는 온라인테스트 문제 목록 조회 
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public MonthlyExamDTO findMonthlyExam(Integer year, Integer month, Integer studentNo, Integer examNo) {
		//TODO:성공 실패 기준값이 없음
		int pass =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(2))
						.and(JExamList.EXAM_LIST.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JExamUser.EXAM_USER.STATUS)
				.fetchOne(0, int.class);
		//TODO:성공 실패 기준값이 없음
		int fail =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(1))
						.and(JExamList.EXAM_LIST.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JExamUser.EXAM_USER.STATUS)
				.fetchOne(0, int.class);
		//TODO:남아 있는 시험 기준이 없음
		int notSubmit =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(0))
						.and(JExamList.EXAM_LIST.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JExamUser.EXAM_USER.STATUS)
				.fetchOne(0, int.class);
		
		//남아 있는 수업
		int remain =
				dslContext.selectCount()
				.from(JClassMngt.CLASS_MNGT)
				.where(JClassMngt.CLASS_MNGT.STUDENT_NO.eq(studentNo)
						.and(JClassMngt.CLASS_MNGT.ATTENDANCE.eq(0))
						.and(JClassMngt.CLASS_MNGT.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JClassMngt.CLASS_MNGT.STUDENT_NO)
				.fetchOne(0, int.class);
		
		return MonthlyExamDTO.builder()
				.pass(pass)
				.fail(fail)
				.notSubmit(notSubmit)
				.remain(remain)
				.build();
	}
	
	
}
