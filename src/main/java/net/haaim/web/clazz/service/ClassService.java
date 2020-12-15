package net.haaim.web.clazz.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.clazz.entity.ClassCurriculumEntity;
import net.haaim.web.clazz.entity.ClassDTO;
import net.haaim.web.clazz.entity.ClassEntity;
import net.haaim.web.clazz.entity.ClassStudentEntity;
import net.haaim.web.clazz.entity.CurriculumEntity;
import net.haaim.web.clazz.repository.ClassCurriculumRepository;
import net.haaim.web.clazz.repository.ClassStudentRepository;
import net.haaim.web.clazz.repository.ClazzRepository;
import net.haaim.web.clazz.repository.ClazzRepositoryJOOQ;
import net.haaim.web.common.User;

@Service
public class ClassService {
	@Autowired
	private ClazzRepositoryJOOQ repo;
	
	@Autowired
	private ClazzRepository classRepo;
	
	@Autowired
	private ClassStudentRepository classStuentRepo;
	
	@Autowired
	private ClassCurriculumRepository classCurriculumRepo;

	
	public Page<ClassDTO> search(Pageable pageable) {
		//return repo.findAllByOrderByClassNoDesc(pageable);
		return repo.findAllByOrderByNoDesc(pageable);
	}

	public Page<CurriculumEntity> search(Integer year, Integer grade, Integer course, String largeCategory,
			Pageable pageable) {
		return null;
	}
	
	@Transactional
	public ClassEntity regist(User user, ClassEntity classEntity, Integer[] curriculumList, Integer[] studentList) {
		
		//save class table
		ClassEntity savedClassEntity = classRepo.save(classEntity);
		
		//save class_student table
		for(Integer studentNo : studentList) {
			ClassStudentEntity e = ClassStudentEntity.builder()
					.classNo(savedClassEntity.getClassNo())
					.studentNo(studentNo)
					.status(ClassStudentEntity.VIEW)
					.inputDate(new Date())
					.inputId(user.getId())
					.build();
			classStuentRepo.save(e);
		}
		
		//save class_curriculum
		for(Integer curriculumNo : curriculumList) {
			ClassCurriculumEntity e = ClassCurriculumEntity.builder()
					.classNo(savedClassEntity.getClassNo())
					.curriculumNo(curriculumNo)
					.inputDate(new Date())
					.inputId(user.getId())
					.build();
			classCurriculumRepo.save(e);
		}

		return savedClassEntity;
	}
}
