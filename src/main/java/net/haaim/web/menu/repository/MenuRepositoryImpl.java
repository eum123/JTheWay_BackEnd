package net.haaim.web.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPAExpressions;

import net.haaim.web.authority.entity.QAuthorityEntity;
import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.entity.QMenuEntity;

public class MenuRepositoryImpl extends QuerydslRepositorySupport implements MenuRepositoryCustom {
	
	public MenuRepositoryImpl() {
		super(MenuEntity.class);
	}
	
	public List<MenuEntity> findAllByUserTypeAndUsage(Role userType, int usage) {
		return from(QMenuEntity.menuEntity)
		.where(QMenuEntity.menuEntity.menuCode.in(
						JPAExpressions.select(QAuthorityEntity.authorityEntity.menuCode)
							.from(QAuthorityEntity.authorityEntity)
							.where(QAuthorityEntity.authorityEntity.userType.eq(userType)
									.and(QAuthorityEntity.authorityEntity.usage.eq(usage)))
						)
				)
		.fetch();
	}
}
