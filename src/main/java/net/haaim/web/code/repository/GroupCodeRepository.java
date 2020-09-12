package net.haaim.web.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.code.entity.GroupCodeEntity;

public interface GroupCodeRepository extends JpaRepository<GroupCodeEntity, String>{
	
}
