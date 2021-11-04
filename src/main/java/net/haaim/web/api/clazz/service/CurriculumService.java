package net.haaim.web.api.clazz.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.CurriculumEntity;
import net.haaim.web.api.clazz.repository.CurriculumMapper;

@RequiredArgsConstructor
@Service
public class CurriculumService {

	private final CurriculumMapper mapper;

	/**
	 * 커리큘럼 저장.
	 * @param entity
	 * @return
	 */
	public CurriculumEntity save(CurriculumEntity entity) {
		
		Integer cno = mapper.save(entity);
		entity.setCno(cno);
		
		return entity;
	}
	
	/**
	 * 커리큘럼 목록 조회.
	 * @param year
	 * @param grade
	 * @param course
	 * @param largeCategory
	 * @param mediumCategory
	 * @return
	 */
	public Page<CurriculumEntity> findAllByYearAndGradeAndCourseAndLargeCategoryAndMediumCateogry(
			Integer year, String grade, String course, String largeCategory,
			String mediumCategory ){
		return mapper.findAllByYearAndGradeAndCourseAndLargeCategoryAndMediumCateogry(year, grade, course, largeCategory, mediumCategory);
	}
}
