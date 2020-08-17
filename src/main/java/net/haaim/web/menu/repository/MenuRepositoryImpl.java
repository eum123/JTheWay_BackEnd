package net.haaim.web.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.entity.QMenuEntity;

public class MenuRepositoryImpl extends QuerydslRepositorySupport implements MenuRepositoryCustom {
	
	public MenuRepositoryImpl() {
		super(MenuEntity.class);
	}
	
	public List<MenuEntity> findAllByUsage(int usage) {
		
		return from(QMenuEntity.menuEntity)
		.where(QMenuEntity.menuEntity.usage.eq(usage))
		.orderBy(QMenuEntity.menuEntity.menuCode.asc(), QMenuEntity.menuEntity.parentMenuCode.asc())
		.fetch();
			
	}
}
