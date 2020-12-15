package net.haaim.web.clazz.repository;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import net.haaim.web.clazz.entity.ClassDTO;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JClassStudent;
import net.haaim.web.jooq.entity.tables.JCurriculum;
import net.haaim.web.jooq.entity.tables.JUser;

@Repository
public class ClazzRepositoryJOOQ {
	private final DSLContext dslContext;

	public ClazzRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
	}
	
	public Page<ClassDTO> findAllByOrderByNoDesc(Pageable pageable) {
		
		Table<?> nested =
				dslContext.select(JClassStudent.CLASS_STUDENT.CLASS_NO, DSL.count().as("cnt"))
			          .from(JClassStudent.CLASS_STUDENT)
			          .groupBy(JClassStudent.CLASS_STUDENT.CLASS_NO).asTable("class_student");
		
		List<ClassDTO> list = dslContext.select(
				JClass.CLASS.CLASS_NO
				, JClass.CLASS.CLASS_NAME
				, JClass.CLASS.YEAR
				, JClass.CLASS.START_DATE
				, JClass.CLASS.END_DATE
				, JClass.CLASS.DAY_TIME
				, JClass.CLASS.TEXTBOOK
				, JClass.CLASS.PASS_SCORE
				, JClass.CLASS.DESCRIPTION
				//, JClass.CLASS.CURRICULUM_NO
				//, JCurriculum.CURRICULUM.COURSE
				, JClass.CLASS.TEACHER_NO
				, JUser.USER.USER_ID
				, JUser.USER.NAME
				, DSL.ifnull(nested.field("cnt"), 0).as("student_cnt"))
			.from(JClass.CLASS
				.join(JUser.USER).on(JClass.CLASS.TEACHER_NO.eq(JUser.USER.NO))
				//.join(JCurriculum.CURRICULUM).on(JClass.CLASS.CURRICULUM_NO.eq(JCurriculum.CURRICULUM.NO))
				.leftJoin(nested).on(JClass.CLASS.CLASS_NO.eq(nested.field("class_no", Integer.class)))
			 )
			.orderBy(JClass.CLASS.CLASS_NO.desc())
			.offset((int)pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch()
			.into(ClassDTO.class);
		
		int totalCount = dslContext.fetchCount(JClass.CLASS);
		
		return new PageImpl<ClassDTO>(list, pageable, totalCount);
		
	}

}
