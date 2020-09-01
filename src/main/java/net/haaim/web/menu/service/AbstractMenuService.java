package net.haaim.web.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.repository.MenuRepository;

public abstract class AbstractMenuService implements MenuService {

	@Autowired
	protected MenuRepository repo;
	
	public abstract List<MenuEntity> search(Role useType, int usage);

}
