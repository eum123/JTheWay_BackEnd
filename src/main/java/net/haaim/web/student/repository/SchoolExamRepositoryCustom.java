package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.student.entity.SchoolExamEntity;

public interface SchoolExamRepositoryCustom {
	public Page<SchoolExamEntity> findAllByStudentNoByOrderByNoDes(Integer studentNo, Pageable pageable);
}
