package net.haaim.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.common.Role;
import net.haaim.web.user.entity.UserEntity;
import net.haaim.web.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public Page<UserEntity> search(PageRequest pageable) {
		return repo.findAll(pageable);
	}

	public Page<UserEntity> search(Integer userType, Integer usage, String key, PageRequest pageable) {

		int useYn = 0;
		if (usage == null) {
			useYn = CodeEntity.VIEW;
		} else {
			useYn = usage.intValue();
		}
		
		return repo.findAllUserTypeAndUsageOrKey(Role.getRole(userType), useYn, key, pageable);
		
	}
}
