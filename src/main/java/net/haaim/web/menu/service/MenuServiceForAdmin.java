package net.haaim.web.menu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.common.Role;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.notice.entity.NoticeEntity;

@Service
public class MenuServiceForAdmin extends AbstractMenuService {
	
	
	public List<MenuEntity> search(Role useType, int usage) {

		return repo.findAllByUserTypeAndUsage(useType, usage);
	}

	
}
