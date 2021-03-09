package net.haaim.web.student.repository;

import org.jooq.DSLContext;
import org.jooq.conf.StatementType;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.DateHelper;
import net.haaim.web.jooq.entity.tables.JClassMngt;
import net.haaim.web.student.entity.MonthlyAttendanceDTO;

@Slf4j
@Repository
public class MonthlyAttendanceRepositoryJOOQ {
	private final DSLContext dslContext;

	public MonthlyAttendanceRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
		this.dslContext.settings().setStatementType(StatementType.PREPARED_STATEMENT);
		
	}
	
	/**
	 * 출제번호에 맞는 온라인테스트 문제 목록 조회 
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public MonthlyAttendanceDTO findMonthlyAttendance(Integer year, Integer month, Integer studentNo) {
		int attendanceCount =
				dslContext.selectCount()
				.from(JClassMngt.CLASS_MNGT)
				.where(JClassMngt.CLASS_MNGT.STUDENT_NO.eq(studentNo)
						.and(JClassMngt.CLASS_MNGT.ATTENDANCE.eq(2))
						.and(JClassMngt.CLASS_MNGT.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JClassMngt.CLASS_MNGT.STUDENT_NO)
				.fetchOne(0, int.class);
		
		int missCount =
				dslContext.selectCount()
				.from(JClassMngt.CLASS_MNGT)
				.where(JClassMngt.CLASS_MNGT.STUDENT_NO.eq(studentNo)
						.and(JClassMngt.CLASS_MNGT.ATTENDANCE.eq(1))
						.and(JClassMngt.CLASS_MNGT.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JClassMngt.CLASS_MNGT.STUDENT_NO)
				.fetchOne(0, int.class);
		
		int remainCount =
				dslContext.selectCount()
				.from(JClassMngt.CLASS_MNGT)
				.where(JClassMngt.CLASS_MNGT.STUDENT_NO.eq(studentNo)
						.and(JClassMngt.CLASS_MNGT.ATTENDANCE.eq(0))
						.and(JClassMngt.CLASS_MNGT.DATE.between(DateHelper.toString(year, month, 0, 0, 0, 0), DateHelper.toString(year, month, 32, 0, 0, 0))))
				.groupBy(JClassMngt.CLASS_MNGT.STUDENT_NO)
				.fetchOne(0, int.class);
		
		return MonthlyAttendanceDTO.builder()
				.attendance(attendanceCount)
				.miss(missCount)
				.remain(remainCount)
				.build();
	}
	
	
}
