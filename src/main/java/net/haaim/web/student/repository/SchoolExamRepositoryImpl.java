package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.QueryResults;

import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.student.entity.QSchoolExamEntity;
import net.haaim.web.student.entity.SchoolExamEntity;

public class SchoolExamRepositoryImpl extends QuerydslRepositorySupport implements SchoolExamRepositoryCustom {

	public SchoolExamRepositoryImpl() {
		super(NoticeEntity.class);
	}
	
	/**
	 * 학생 (student_no)로 학교 성정 조회
	 */
	public Page<SchoolExamEntity> findAllByStudentNoByOrderByNoDes(Integer studentNo, Pageable pageable) {
		QueryResults<SchoolExamEntity> result = from(QSchoolExamEntity.schoolExamEntity)
				.where(QSchoolExamEntity.schoolExamEntity.studentNo.eq(studentNo))
				.orderBy(QSchoolExamEntity.schoolExamEntity.no.desc())
				.fetchResults();
				
		return new PageImpl<SchoolExamEntity>(result.getResults(), pageable, result.getTotal());
		
	}
	
}
