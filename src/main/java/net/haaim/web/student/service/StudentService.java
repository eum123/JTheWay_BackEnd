package net.haaim.web.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.student.repository.StudentRepository;
import net.haaim.web.user.entity.UserEntity;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Page<UserEntity> search(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	//TODO:
	public Page<UserEntity> search(String title, String contents, int usage, PageRequest pageable) {

		int useYn = 0;
//		if (usage == null) {
//			useYn = CodeEntity.VIEW;
//		} else {
//			useYn = usage.intValue();
//		}
		
		return repo.findAllByTitleAndContents(title, contents, usage, pageable);

	}
	
	public UserEntity save(UserEntity userEntity) {
		return null;
	}
}
