package net.haaim.web.menu.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.swagger.models.Response;
import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuContentResponse;
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

	@Override
	public List<MenuContentResponse> finalAll() {
		
		return getMenuContentResponse(repo.findAllMenu());
	}

	@Override
	public List<MenuContentResponse> findAllByUsageAndMenuName(int usage, String menuName) {
		return getMenuContentResponse(repo.findAllByUsageAndMenuName(usage, menuName));
	}

	private List<MenuContentResponse> getMenuContentResponse(List<String> data) {
		List<MenuContentResponse> list = new ArrayList();
		data.forEach(x -> {
			MenuContentResponse response = new MenuContentResponse();
			
			String entityString = x.substring(0, x.lastIndexOf(","));
			String userTypesString = x.substring(x.lastIndexOf(",") + 1);
			
			response.setMenuEntity(entityString);
			response.setUserTypes(userTypesString);
			
			list.add(response);
		});
		return list;
	}
}
