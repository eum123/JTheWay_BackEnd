package net.haaim.web.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.exam.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
	
}
