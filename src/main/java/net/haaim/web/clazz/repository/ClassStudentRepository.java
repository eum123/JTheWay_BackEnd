package net.haaim.web.clazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.clazz.entity.ClassStudentEntity;

public interface ClassStudentRepository extends JpaRepository<ClassStudentEntity, Integer> {
	
}
