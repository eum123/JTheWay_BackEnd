package net.haaim.web.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.response.ApiResponse;
import net.haaim.web.menu.service.MenuService;
import net.haaim.web.menu.service.MenuServiceFactory;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuServiceFactory factory;

	@RequestMapping(value = "searchAll", method = RequestMethod.GET)
	public ApiResponse search() {
		//사용자의 권한을 확인
		User user = UserHelper.getUser();
		
		try {
		
			MenuService service = factory.getInstance(user);
			
			return null;
			//return ApiResponse.getSuccessResponse(service.);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	} 
}
