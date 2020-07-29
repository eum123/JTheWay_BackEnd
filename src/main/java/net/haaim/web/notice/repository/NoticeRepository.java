package net.haaim.web.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.notice.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {
	/**
	 * 제목 like 검색
	 * 
	 * @param title
	 * @param state
	 * @param pageable
	 * @return
	 */
	Page<NoticeEntity> findByTitleContainingAndState(String title, int state, Pageable pageable);

	/**
	 * 제목 like and 내용 like 검색
	 * 
	 * @param title
	 * @param content
	 * @param state
	 * @param pageable
	 * @return
	 */
	Page<NoticeEntity> findByTitleContainingAndContentsContainingAndState(String title, String content, int state,
			Pageable pageable);
}
