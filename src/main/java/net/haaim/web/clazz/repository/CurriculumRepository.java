package net.haaim.web.clazz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.clazz.entity.CurriculumEntity;

public interface CurriculumRepository extends JpaRepository<CurriculumEntity, Integer>, CurriculumRepositoryCustom {
	Page<CurriculumEntity> findAllByOrderByNoDesc(Pageable pageable);
}
