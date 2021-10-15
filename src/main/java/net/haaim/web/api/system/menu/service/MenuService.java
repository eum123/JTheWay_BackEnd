package net.haaim.web.api.system.menu.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.system.menu.entity.MenuEntity;
import net.haaim.web.api.system.menu.entity.MenuResponse;
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
	public List<MenuResponse> findAll(Integer userType, Integer useYn) {
		List<MenuEntity> list = menuMapper.findAll(userType, useYn);
		
		Map<String, MenuResponse> response = new LinkedHashMap();
		list.forEach(x -> {
			
			if(x.getParentMenuCode() == null || x.getParentMenuCode().trim().length() == 0) {
				//main
				MenuResponse r = getMenuResponse(response, x.getMenuCode());
				r.setPrimary(x);
			} else {
				//sub
				MenuResponse r = getMenuResponse(response, x.getParentMenuCode());
				r.addSecondary(x);
			}
			
		});
		
		return List.copyOf(response.values());
		
	}
	
	private MenuResponse getMenuResponse(Map<String, MenuResponse> response, String menuCode) {
		if(!response.containsKey(menuCode)) {
			response.put(menuCode, new MenuResponse());
		} 
		
		return response.get(menuCode);
	}
}
