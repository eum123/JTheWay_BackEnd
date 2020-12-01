package net.haaim.web.clazz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import net.haaim.web.clazz.entity.ClazzEntity;

public class ClazzRepositoryImpl extends QuerydslRepositorySupport implements ClazzRepositoryCustom {

	public ClazzRepositoryImpl() {
		super(ClazzEntity.class);
	}
	
	/**
	 * 학생 (student_no)로 학교 성정 조회
	 */
	public Page<ClazzEntity> findAllByStudentNoByOrderByNoDes(Integer studentNo, Pageable pageable) {
//		QueryResults<SchoolExamEntity> result = from(QSchoolExamEntity.schoolExamEntity)
//				.where(QSchoolExamEntity.schoolExamEntity.studentNo.eq(studentNo))
//				.orderBy(QSchoolExamEntity.schoolExamEntity.no.desc())
//				.fetchResults();
//				
//		return new PageImpl<ClazzEntity>(result.getResults(), pageable, result.getTotal());
		return null;
		
	}
	
}
