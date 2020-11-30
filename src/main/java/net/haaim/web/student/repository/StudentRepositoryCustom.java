package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.user.entity.UserEntity;

public interface StudentRepositoryCustom {
	public Page<UserEntity> findAllByTitleAndContents(String title, String contents, int usage, Pageable pageable);
	
}
