package net.haaim.web.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.common.Role;
import net.haaim.web.user.entity.DuplicateEntity;
import net.haaim.web.user.entity.UserEntity;
import net.haaim.web.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public Page<UserEntity> search(Pageable pageable) {
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

	/**
	 * ID 중복 확인
	 * 
	 * @param userId
	 * @return fase - 종복아님, true - 중복
	 */
	public DuplicateEntity isDuplicate(String userId) {
		return DuplicateEntity.builder().isDuplicate(repo.findAllByUserId(userId).size() == 0 ? false : true).build();
	}
	
	public UserEntity save(UserEntity entity) {
		return repo.save(entity);
	}
	
	public List<UserEntity> seachByUserType(Role userType, Integer usage) {
		
		return repo.findAllByUserTypeAndUsageOrderByName(userType, usage);
	}
}
