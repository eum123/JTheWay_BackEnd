package net.haaim.web.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.haaim.web.common.Role;
import net.haaim.web.user.entity.UserEntity;

public interface UserRepositoryCustom {
	public Page<UserEntity> findAllUserTypeAndUsageOrKey(Role userType, Integer usage, String key, PageRequest pageable);
	
}
