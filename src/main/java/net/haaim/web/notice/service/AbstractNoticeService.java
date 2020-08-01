package net.haaim.web.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.notice.repository.NoticeRepository;

public abstract class AbstractNoticeService implements NoticeService {

	@Autowired
	protected NoticeRepository repo;

	public Page<NoticeEntity> searchAll(Pageable pageable) {
		return repo.findByState(NoticeEntity.VIEW, pageable);
	}

	public NoticeEntity search(int no) {
		return repo.getOne(no);
	}

	public abstract Page<NoticeEntity> search(Pageable pageable);

	public abstract Page<NoticeEntity> search(String title, String contents, Pageable pageable);

}
