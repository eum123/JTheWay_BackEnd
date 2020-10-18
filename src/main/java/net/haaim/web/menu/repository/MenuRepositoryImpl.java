package net.haaim.web.menu.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public List<String> findAllMenu() {
		
		EntityManager em = getEntityManager();

        StringBuilder sb = new StringBuilder();

        sb.append("SELECT parent_menu_code, menu_code, menu_name, url, (\n");
        sb.append("  SELECT GROUP_CONCAT(user_type SEPARATOR '|')\n");
        sb.append("  FROM authority\n");
        sb.append("  WHERE menu_code = m.menu_code\n");
        sb.append("  ORDER BY user_type) as user_type\n");
        sb.append("FROM menu m\n");
        
        Query query = em.createNativeQuery(sb.toString());
       
        return query.getResultList();
        
	}
	
	public List<String> findAllByUsageAndMenuName(int usage, String menuName) {
		return null;
	}
}
