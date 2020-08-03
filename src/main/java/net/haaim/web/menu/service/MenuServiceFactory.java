package net.haaim.web.menu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.haaim.web.common.Role;
import net.haaim.web.common.User;

@Component
public class MenuServiceFactory {
	@Autowired
	private MenuServiceForStudent noticeStudent;
	@Autowired
	private MenuServiceForAdmin noticeAdmin;
	
	public MenuService getInstance(User user) {
		if(user.getRole() == Role.STUDENT) {
			return noticeStudent;
		} else {
			return noticeAdmin;
		}
	}
}
