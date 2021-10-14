package net.haaim.web.api.system.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.system.menu.entity.MenuEntity;
import net.haaim.web.api.system.menu.repository.MenuMapper;

@RequiredArgsConstructor
@Service
public class MenuService {
	
	private final MenuMapper menuMapper;

	/**
	 * 메뉴를 저장한다.
	 * @param entity
	 */
	public void save(MenuEntity entity) {
		
	}
	
	/**
	 * 메뉴 전체 목록을 조회 한다.
	 * @return
	 */
	public List<MenuEntity> findAll() {
		return menuMapper.findAll();
	}
}
