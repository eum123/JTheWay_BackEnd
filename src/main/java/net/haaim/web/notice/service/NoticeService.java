package net.haaim.web.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.notice.entity.NoticeEntity;

public interface NoticeService {
	public Page<NoticeEntity> searchAll(Pageable pageable);
	
	public NoticeEntity search(int no);
	
	public Page<NoticeEntity> search(Pageable pageable) ;
	
	public Page<NoticeEntity> search(String title, String contents, Pageable pageable);
}
