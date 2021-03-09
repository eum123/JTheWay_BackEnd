package net.haaim.web.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.student.entity.AnswerSheetEntity;

public interface AnswerSheetRepository extends JpaRepository<AnswerSheetEntity, Integer>{
	
}
