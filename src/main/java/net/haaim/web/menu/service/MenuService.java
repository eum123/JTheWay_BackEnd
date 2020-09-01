package net.haaim.web.menu.service;

import java.util.List;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;

public interface MenuService {
	public List<MenuEntity> search(Role useType, int usage);
}
