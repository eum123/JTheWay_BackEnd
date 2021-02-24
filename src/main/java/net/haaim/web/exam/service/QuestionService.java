package net.haaim.web.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.exam.entity.QuestionEntity;
import net.haaim.web.exam.repository.QuestionRepositoryJOOQ;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepositoryJOOQ repo;

	
	public Page<QuestionEntity> search(String userId, Pageable pageable) {
		return repo.findAllByUserId(userId, pageable);
	}
}
