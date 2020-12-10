package net.haaim.web.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.common.Role;
import net.haaim.web.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserRepositoryCustom {
	public List<UserEntity> findAllByUserId(String userId);
	
	public List<UserEntity> findAllByUserTypeAndUsageOrderByName(Role userType, Integer usage);
}
