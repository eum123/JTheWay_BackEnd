package net.haaim.web.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.notice.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {

}
