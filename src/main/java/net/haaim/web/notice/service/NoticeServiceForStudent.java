package net.haaim.web.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.notice.entity.NoticeEntity;

@Service
public class NoticeServiceForStudent extends AbstractNoticeService {
	
	public Page<NoticeEntity> search(Pageable pageable) {
		return repo.findByState(NoticeEntity.VIEW, pageable);
	}
	
	public Page<NoticeEntity> search(String title, String contents, Pageable pageable) {
		if((title == null || title.trim().length() == 0) && (contents == null || contents.trim().length() == 0)) {
			//search all
			return repo.findByState(NoticeEntity.VIEW, pageable);
		} else if(title == null || title.trim().length() == 0) {
			return repo.findByContentsContainingAndState(contents, NoticeEntity.VIEW, pageable);
		} else {
			return repo.findByTitleContainingAndState(title, NoticeEntity.VIEW, pageable);
		}
	}
	
	
}
