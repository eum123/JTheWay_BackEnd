package net.haaim.web.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;

@Service
public class MenuServiceForStudent extends AbstractMenuService {
	
	public List<MenuEntity> search(Role useType, int usage) {
		//학생은 메뉴가 없음
		return new ArrayList();
	}
}
