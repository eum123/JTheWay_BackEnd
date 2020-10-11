package net.haaim.web.notice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;

import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.notice.entity.QNoticeEntity;

public class NoticeRepositoryImpl extends QuerydslRepositorySupport implements NoticeRepositoryCustom {

	public NoticeRepositoryImpl() {
		super(NoticeEntity.class);
	}

	public Page<NoticeEntity> findAllByTitleAndContents(String title, String contents, int usage, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QNoticeEntity.noticeEntity.state.eq(usage));
		
		if(title != null && !title.equals("")) {
			builder.and(QNoticeEntity.noticeEntity.title.like(title).or(QNoticeEntity.noticeEntity.title.like(title)));
		}
		if(contents != null && !contents.equals("")) {
			builder.and(QNoticeEntity.noticeEntity.contents.like(contents).or(QNoticeEntity.noticeEntity.contents.like(contents)));
		}
		
		QueryResults<NoticeEntity> result = from(QNoticeEntity.noticeEntity)
				.where(builder	)
				.offset(pageable.getOffset()).limit(pageable.getPageSize())
				.orderBy(QNoticeEntity.noticeEntity.no.desc()).fetchResults();

		return new PageImpl<NoticeEntity>(result.getResults(), pageable, result.getTotal());
	}
}
