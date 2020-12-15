package net.haaim.web.clazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.clazz.entity.ClassEntity;

public interface ClazzRepository extends JpaRepository<ClassEntity, Integer> {
	
}
