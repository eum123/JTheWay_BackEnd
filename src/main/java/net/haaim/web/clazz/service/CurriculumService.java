package net.haaim.web.clazz.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.clazz.entity.CurriculumEntity;
import net.haaim.web.clazz.repository.CurriculumRepository;
import net.haaim.web.common.User;

@Service
public class CurriculumService {
	@Autowired
	private CurriculumRepository repo;

	public Page<CurriculumEntity> search(Pageable pageable) {
		return repo.findAllByOrderByNoDesc(pageable);
	}

	public Page<CurriculumEntity> search(Integer year, Integer grade, Integer course, String largeCategory,
			Pageable pageable) {
		return repo.findAllByYearAndGradeAndCourseAndLargeCategory(year, grade, course, largeCategory, pageable);
	}
	
	public CurriculumEntity regist(User user, Integer year, Integer grade, Integer course, String largeCategory, String mediumCategory) {
		CurriculumEntity entity = CurriculumEntity.builder()
			.year(year)
			.grade(grade)
			.course(course)
			.largeCategory(largeCategory)
			.mediumCategory(mediumCategory)
			.inputDate(new Date())
			.inputId(user.getId())
			.build();
		return repo.save(entity);
	}
}
