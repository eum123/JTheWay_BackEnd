package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.student.entity.SchoolExamEntity;

public interface SchoolExamRepository extends JpaRepository<SchoolExamEntity, Integer>, SchoolExamRepositoryCustom {
	
}
