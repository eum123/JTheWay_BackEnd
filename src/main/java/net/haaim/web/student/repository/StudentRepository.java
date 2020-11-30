package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.user.entity.UserEntity;

public interface StudentRepository extends JpaRepository<UserEntity, Integer>, StudentRepositoryCustom {
//	Page<UserEntity> findAllByStateOrderByNoDesc(int state, Pageable pageable);
	Page<UserEntity> findAllByOrderByNoDesc(Pageable pageable);

}
