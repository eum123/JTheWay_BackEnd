package net.haaim.web.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;

import net.haaim.web.common.Role;
import net.haaim.web.user.entity.QUserEntity;
import net.haaim.web.user.entity.UserEntity;

public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

	public UserRepositoryImpl() {
		super(UserEntity.class);
	}	
	
	public Page<UserEntity> findAllUserTypeAndUsageOrKey(Role userType, Integer usage, String key, PageRequest pageable) {
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(QUserEntity.userEntity.usage.eq(usage));
		builder.and(QUserEntity.userEntity.userType.eq(userType));
		
		if(key != null && !key.equals("")) {
			builder.and(QUserEntity.userEntity.name.like(key).or(QUserEntity.userEntity.mobile.like(key)));
		}
		
		QueryResults<UserEntity> result = from(QUserEntity.userEntity)
				.where(builder)
				.offset(pageable.getOffset()).limit(pageable.getPageSize())
				.orderBy(QUserEntity.userEntity.name.asc()).fetchResults();
		
		return null;
	}
}
