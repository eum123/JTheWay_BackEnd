package net.haaim.web.student.repository;

import java.util.List;

import javax.persistence.Column;

import org.jooq.DSLContext;
import org.jooq.conf.StatementType;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.DateHelper;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JClassMngt;
import net.haaim.web.jooq.entity.tables.JClassStudent;
import net.haaim.web.jooq.entity.tables.JExamList;
import net.haaim.web.jooq.entity.tables.JExamUser;
import net.haaim.web.student.entity.MonthlyClassDTO;
import net.haaim.web.student.entity.MonthlyExamDTO;

@Slf4j
@Repository
public class StudentRepositoryJOOQ {
	private final DSLContext dslContext;

	public StudentRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
		this.dslContext.settings().setStatementType(StatementType.PREPARED_STATEMENT);
		
	}
	
	public List<MonthlyClassDTO> findAllMonthlyClass(Integer year, Integer month, Integer classNo, Integer studentNo) {
		return dslContext.select(
				JClass.CLASS.CLASS_NO,
				JClass.CLASS.CLASS_NAME,
				JClass.CLASS.START_DATE,
				JClass.CLASS.END_DATE,
				JClass.CLASS.DAY_TIME
		)
		.from(JClass.CLASS)
		.join(JClassStudent.CLASS_STUDENT).on(JClass.CLASS.CLASS_NO.eq(JClassStudent.CLASS_STUDENT.CLASS_NO))
		.where(JClassStudent.CLASS_STUDENT.STUDENT_NO.eq(studentNo)
				.and(JClass.CLASS.CLASS_NO.eq(classNo)))
		.fetch()
		.into(MonthlyClassDTO.class);
		
	}
	
	/**
	 * 출제번호에 맞는 온라인테스트 문제 목록 조회 
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public MonthlyExamDTO findMonthlyExam(Integer year, Integer month, Integer studentNo, Integer examNo) {
		//성공/실패 기준값
		int passScore = dslContext.select(
				JClass.CLASS.PASS_SCORE
			)
			.from(JClass.CLASS)
			.join(JClassStudent.CLASS_STUDENT).on(JClass.CLASS.CLASS_NO.eq(JClassStudent.CLASS_STUDENT.CLASS_NO))
			.where(JClassStudent.CLASS_STUDENT.STUDENT_NO.eq(studentNo))
			.fetchOne(0, int.class);
		
		//성공
		int pass =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(2))
						.and(JExamUser.EXAM_USER.SCORE.greaterOrEqual(passScore))
						.and(JExamList.EXAM_LIST.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JExamUser.EXAM_USER.STATUS)
				.fetchOne(0, int.class);
		
		//실패
		int fail =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(2))
						.and(JExamUser.EXAM_USER.SCORE.lessThan(passScore))
						.and(JExamList.EXAM_LIST.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JExamUser.EXAM_USER.STATUS)
				.fetchOne(0, int.class);
		//TODO:남아 있는 시험 기준이 없음
		int notSubmit =
				dslContext.selectCount()
				.from(JExamUser.EXAM_USER)
				.leftJoin(JExamList.EXAM_LIST).on(JExamUser.EXAM_USER.EXAM_NO.eq(JExamList.EXAM_LIST.EXAM_NO))
				.where(JExamUser.EXAM_USER.STUDENT_NO.eq(studentNo)
						.and(JExamUser.EXAM_USER.STATUS.eq(1))
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
