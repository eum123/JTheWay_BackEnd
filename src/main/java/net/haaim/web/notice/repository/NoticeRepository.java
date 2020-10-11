package net.haaim.web.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.notice.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer>, NoticeRepositoryCustom {
	Page<NoticeEntity> findAllByStateOrderByNoDesc(int state, Pageable pageable);
	Page<NoticeEntity> findAllByOrderByNoDesc(Pageable pageable);

}
