package net.haaim.web.notice.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.common.User;
import net.haaim.web.notice.entity.NoticeEntity;

@Service
public class NoticeServiceForAdmin extends AbstractNoticeService {
	
	public Page<NoticeEntity> search(Pageable pageable) {
		return repo.findAllByOrderByNoDesc(pageable);
	}
	
	public Page<NoticeEntity> search(String title, String contents, Pageable pageable) {
		return repo.findAllByTitleAndContents(title, contents, NoticeEntity.VIEW, pageable);
	}

	@Override
	public void regist(User user, String title, String contents) {
		NoticeEntity entity = NoticeEntity.builder()
				.title(title)
				.contents(contents)
				.state(NoticeEntity.VIEW)
				.inputId(user.getId())
				.inputDate(new Date())
				.build();
		
		repo.save(entity);
	}
}
