package net.haaim.web.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.code.entity.CodeEntity;

public interface CodeRepository extends JpaRepository<CodeEntity, String>, CodeRepositoryCustom {
	
}
