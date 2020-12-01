package net.haaim.web.clazz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.clazz.entity.ClazzEntity;

public interface ClazzRepositoryCustom {
	public Page<ClazzEntity> findAllByStudentNoByOrderByNoDes(Integer studentNo, Pageable pageable);
}
