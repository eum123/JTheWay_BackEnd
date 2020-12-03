package net.haaim.web.clazz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;

import net.haaim.web.clazz.entity.CurriculumEntity;
import net.haaim.web.clazz.entity.QCurriculumEntity;

public class CurriculumRepositoryImpl extends QuerydslRepositorySupport implements CurriculumRepositoryCustom {

	public CurriculumRepositoryImpl() {
		super(CurriculumEntity.class);
	}
	
	/**
	 * 검색 목록 조회
	 */
	public Page<CurriculumEntity> findAllByYearAndGradeAndCourseAndLargeCategory(Integer year, Integer grade, Integer course, String largeCategory, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		
		if(year != null) {
			builder.and(QCurriculumEntity.curriculumEntity.year.eq(year));
		}
		if(grade != null) {
			builder.and(QCurriculumEntity.curriculumEntity.grade.eq(grade));
		}
		if(course != null) {
			builder.and(QCurriculumEntity.curriculumEntity.course.eq(course));
		}
		if(largeCategory != null && !largeCategory.equals("")) {
			builder.and(QCurriculumEntity.curriculumEntity.largeCategory.like(largeCategory));
		}
		
		QueryResults<CurriculumEntity> result = from(QCurriculumEntity.curriculumEntity)
				.where(builder	)
				.offset(pageable.getOffset()).limit(pageable.getPageSize())
				.orderBy(QCurriculumEntity.curriculumEntity.no.desc()).fetchResults();

		return new PageImpl<CurriculumEntity>(result.getResults(), pageable, result.getTotal());

	}
}
	

