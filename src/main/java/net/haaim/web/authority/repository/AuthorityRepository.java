package net.haaim.web.authority.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.authority.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String>{

}
