package net.haaim.web.menu.repository;

import java.util.List;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;

public interface MenuRepositoryCustom {
	public List<MenuEntity> findAllByUserTypeAndUsage(Role userType, int usage);
}
