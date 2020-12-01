package net.haaim.web.clazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.clazz.entity.ClazzEntity;

public interface ClazzRepository extends JpaRepository<ClazzEntity, Integer>, ClazzRepositoryCustom {
	
}
