package net.haaim.web.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.notice.entity.NoticeEntity;

@Service
public class NoticeServiceForAdmin extends NoticeService {
	
	public Page<NoticeEntity> search(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	public Page<NoticeEntity> search(String title, String contents, Pageable pageable) {
		if((title == null || title.trim().length() == 0) && (contents == null || contents.trim().length() == 0)) {
			
			return repo.findAll(pageable);
		} else if(title == null || title.trim().length() == 0) {
			return repo.findByContentsContaining(contents, pageable);
		} else {
			return repo.findByTitleContaining(title, pageable);
		}
	}
}
