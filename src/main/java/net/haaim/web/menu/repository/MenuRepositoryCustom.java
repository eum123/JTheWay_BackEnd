package net.haaim.web.menu.repository;

import java.util.List;
import java.util.Map;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;

public interface MenuRepositoryCustom {
	public List<MenuEntity> findAllByUserTypeAndUsage(Role userType, int usage);
	
	public List<String> findAllMenu();
	
	public List<String> findAllByUsageAndMenuName(int usage, String menuName);
}
