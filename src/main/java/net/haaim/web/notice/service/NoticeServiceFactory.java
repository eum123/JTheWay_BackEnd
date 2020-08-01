package net.haaim.web.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.haaim.web.common.Role;
import net.haaim.web.common.User;

@Component
public class NoticeServiceFactory {
	@Autowired
	private NoticeServiceForStudent noticeStudent;
	@Autowired
	private NoticeServiceForAdmin noticeAdmin;
	
	public NoticeService getInstance(User user) {
		if(user.getRole() == Role.STUDENT) {
			return noticeStudent;
		} else {
			return noticeAdmin;
		}
	}
}
