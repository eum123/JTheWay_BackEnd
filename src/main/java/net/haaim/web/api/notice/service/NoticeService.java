package net.haaim.web.api.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.notice.entity.NoticeEntity;
import net.haaim.web.api.notice.repository.NoticeMapper;

@RequiredArgsConstructor
@Service
public class NoticeService {
	
	private final NoticeMapper mapper;

	
	public NoticeEntity save(NoticeEntity entity) {
		Integer no = mapper.save(entity);
		entity.setNo(no);
		
		return entity;
	}
	
	/**
	 * 목록 조회.
	 * @param state
	 * @param title
	 * @param contents
	 * @return
	 */
	public List<NoticeEntity> findAllByStateAndTitleOrContens(Integer state, String title, String contents) {
		return mapper.findAllByStateAndTitleOrContens(state, title, contents);
	}
}
