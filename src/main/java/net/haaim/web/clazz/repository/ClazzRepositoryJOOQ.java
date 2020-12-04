package net.haaim.web.clazz.repository;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import net.haaim.web.clazz.entity.ClazzDTO;
import net.haaim.web.jooq.entity.tables.JClass;
import net.haaim.web.jooq.entity.tables.JCurriculum;
import net.haaim.web.jooq.entity.tables.JUser;

@Repository
public class ClazzRepositoryJOOQ {
	private final DSLContext dslContext;

	public ClazzRepositoryJOOQ(DSLContext dslContext) {
		this.dslContext = dslContext;
	}
	
	public Page<ClazzDTO> findAllByOrderByNoDesc(Pageable pageable) {
		List<ClazzDTO> list = dslContext.select()
			.from(JClass.CLASS)
			.join(JUser.USER).on(JClass.CLASS.TEACHER_NO.eq(JUser.USER.NO))
			.join(JCurriculum.CURRICULUM).on(JClass.CLASS.CURRICULUM_NO.eq(JCurriculum.CURRICULUM.NO))
			.orderBy(JClass.CLASS.CLASS_NO.desc())
			.offset((int)pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch()
			.into(ClazzDTO.class);
		
		int totalCount = dslContext.fetchCount(JClass.CLASS);
		
		return new PageImpl<ClazzDTO>(list, pageable, totalCount);
		
	}

}
