package net.haaim.web.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.common.User;
import net.haaim.web.notice.entity.NoticeEntity;

@Service
public class NoticeServiceForStudent extends AbstractNoticeService {
	
	public Page<NoticeEntity> search(Pageable pageable) {
		
		return repo.findAllByStateOrderByNoDesc(NoticeEntity.VIEW, pageable);
		
	}
	
	public Page<NoticeEntity> search(String title, String contents, Pageable pageable) {
		return repo.findAllByTitleAndContents(title, contents, NoticeEntity.VIEW, pageable);
		
	}

	@Override
	public void regist(User user, String title, String contents) {
		// 학색은 공지사항을 저장하지 않는다.
	}
	
	
}
