package net.haaim.web.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;

import net.haaim.web.notice.entity.NoticeEntity;
import net.haaim.web.user.entity.QUserEntity;
import net.haaim.web.user.entity.UserEntity;

public class StudentRepositoryImpl extends QuerydslRepositorySupport implements StudentRepositoryCustom {

	public StudentRepositoryImpl() {
		super(NoticeEntity.class);
	}
	//TODO:
	public Page<UserEntity> findAllByTitleAndContents(String title, String contents, int usage, Pageable pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QUserEntity.userEntity.usage.eq(usage));
		//builder.and(QUserEntity.userEntity.userType.eq(userType));
		
//		if(key != null && !key.equals("")) {
//			builder.and(QUserEntity.userEntity.name.like(key).or(QUserEntity.userEntity.mobile.like(key)));
//		}
		
		QueryResults<UserEntity> result = from(QUserEntity.userEntity)
				.where(builder)
				.offset(pageable.getOffset()).limit(pageable.getPageSize())
				.orderBy(QUserEntity.userEntity.name.asc()).fetchResults();
		
		return new PageImpl<UserEntity>(result.getResults(), pageable, result.getTotal());
	}
}
