package net.haaim.web.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.student.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
}
