package net.haaim.web.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.student.entity.SchoolExamEntity;
import net.haaim.web.student.repository.SchoolExamRepository;
import net.haaim.web.user.entity.UserEntity;

@Service
public class SchoolExamService {
	
	@Autowired
	private SchoolExamRepository repo;
	
	public Page<SchoolExamEntity> search(Integer studentNo, Pageable pageable) {
		
		return repo.findAllByStudentNoByOrderByNoDes(studentNo, pageable);
		
	}
	
	
	public SchoolExamEntity save(SchoolExamEntity userEntity) {
		return null;
	}
}
