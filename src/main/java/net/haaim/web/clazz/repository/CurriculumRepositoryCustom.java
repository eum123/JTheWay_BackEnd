package net.haaim.web.clazz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.clazz.entity.CurriculumEntity;

public interface CurriculumRepositoryCustom {
	public Page<CurriculumEntity> findAllByYearAndGradeAndCourseAndLargeCategory(Integer year, Integer grade, Integer course, String largeCategory, Pageable pageable);
}
