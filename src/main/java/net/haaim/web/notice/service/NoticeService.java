package net.haaim.web.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.notice.repository.NoticeRepository;


public abstract class NoticeService {
	
	@Autowired
	protected NoticeRepository repo;
	
	public Page<NoticeEntity> searchAll(Pageable pageable) {
		return repo.findByState(NoticeEntity.VIEW, pageable);
	}
	
}
