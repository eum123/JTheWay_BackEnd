package net.haaim.web.menu.service;

import java.util.List;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuContentResponse;
import net.haaim.web.menu.entity.MenuResponse;

public interface MenuService {
	public List<MenuResponse> search(Role useType, int usage);
	
	/**
	 * 메뉴 목록 전체
	 * @return
	 */
	public List<MenuContentResponse> finalAll() ;
	
	public List<MenuContentResponse> findAllByUsageAndMenuName(int usage, String menuName);
}
