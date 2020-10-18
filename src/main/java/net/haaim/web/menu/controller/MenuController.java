package net.haaim.web.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.response.ApiResponse;
import net.haaim.web.menu.entity.MenuEntity;
import net.haaim.web.menu.service.MenuService;
import net.haaim.web.menu.service.MenuServiceFactory;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuServiceFactory factory;

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ApiResponse search() {
		//사용자의 권한을 확인
		User user = UserHelper.getUser();
		
		try {
		
			MenuService service = factory.getInstance(user);
			
			return ApiResponse.getSuccessResponse(service.search(user.getRole(), MenuEntity.VIEW));

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	} 
	
	@RequestMapping(value = "searchAll", method = RequestMethod.GET)
	public ApiResponse searchAll() {
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {
			MenuService service = factory.getInstance(user);
			List result = service.finalAll();

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
