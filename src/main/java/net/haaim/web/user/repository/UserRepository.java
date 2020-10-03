package net.haaim.web.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>, UserRepositoryCustom {
	
}
