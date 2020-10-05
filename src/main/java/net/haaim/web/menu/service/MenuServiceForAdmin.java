package net.haaim.web.menu.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.entity.MenuResponse;

@Service
public class MenuServiceForAdmin extends AbstractMenuService {
	
	
	public List<MenuResponse> search(Role useType, int usage) {
		
		List<MenuEntity> list = repo.findAllByUserTypeAndUsage(useType, usage);
		
		//List<MenuResponse> response = new ArrayList();
		
		Map<String, MenuResponse> response = new LinkedHashMap();
		list.forEach(x -> {
			
			if(x.getParentMenuCode() == null || x.getParentMenuCode().trim().length() == 0) {
				//main
				MenuResponse r = getMenuResponse(response, x.getMenuCode());
				r.setPrimaryMenu(x);
			} else {
				//sub
				MenuResponse r = getMenuResponse(response, x.getParentMenuCode());
				r.addSecondary(x);
			}
			
		});

		return new ArrayList(response.values());
	}

	private MenuResponse getMenuResponse(Map<String, MenuResponse> response, String menuCode) {
		if(!response.containsKey(menuCode)) {
			response.put(menuCode, new MenuResponse());
		} 
		
		return response.get(menuCode);
	}
	
}
