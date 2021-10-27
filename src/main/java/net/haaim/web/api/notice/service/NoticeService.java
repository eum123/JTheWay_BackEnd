package net.haaim.web.api.notice.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.notice.entity.NoticeEntity;
import net.haaim.web.api.notice.repository.NoticeMapper;

@Validated
@RequiredArgsConstructor
@Service
public class NoticeService {
	
	private final NoticeMapper mapper;

	
	public NoticeEntity save(@Valid NoticeEntity entity) {
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
	public Page<NoticeEntity> findAllByStateAndTitleOrContens(Integer state, String title, String contents) {
		return mapper.findAllByStateAndTitleOrContens(state, title, contents);
	}
}
