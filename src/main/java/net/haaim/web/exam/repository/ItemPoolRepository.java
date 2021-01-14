package net.haaim.web.exam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.exam.entity.ItemPoolEntity;

public interface ItemPoolRepository extends JpaRepository<ItemPoolEntity, Integer> {
	Page<ItemPoolEntity> findAllByStateOrderByItemNoDesc(int state, Pageable pageable);
	Page<ItemPoolEntity> findAllByOrderByItemNoDesc(Pageable pageable);
}
