package net.haaim.web.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.notice.entity.NoticeEntity;

public interface NoticeRepositoryCustom {
	public Page<NoticeEntity> findAllByTitleAndContents(String title, String contents, int usage, Pageable pageable);
	
}
