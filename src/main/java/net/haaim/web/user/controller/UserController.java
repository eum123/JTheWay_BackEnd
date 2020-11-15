package net.haaim.web.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;
import net.haaim.web.user.entity.UserEntity;
import net.haaim.web.user.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ApiResponse searchAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(service.search(pageable));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "page", defaultValue = "1") Integer page
			, @RequestParam(value = "size", defaultValue = "10") Integer size
			, @RequestParam(value = "user_type", required = false) Integer userType
			, @RequestParam(value = "use_yn", required = false) Integer usage
			, @RequestParam(value = "key", required = false) String key) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(service.search(userType, usage, key, pageable));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "duplicateCheck", method = RequestMethod.GET)
	public ApiResponse duplicateCheck(@RequestParam(value = "user_id", required=true) String userId) {

		try {
			return ApiResponse.getSuccessResponse(service.isDuplicate(userId));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
    
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public ApiResponse regist(
			@RequestParam(value = "user_type", required=true) Integer userType, 
			@RequestParam(value = "state", required=true) Integer state,
			@RequestParam(value = "name", required=true) String name,
			@RequestParam(value = "user_id", required=true) String userId,
			@RequestParam(value = "user_pw", required=true) String password) {
		
		try {
			User user = UserHelper.getUser();
			
			return ApiResponse.getSuccessResponse(service.save(UserEntity.builder()
					.userType(userType)
					.state(state)
					.name(name)
					.userId(userId)
					.userPassword(password)
					.inputDate(new Date())
					.inputId(user.getId()).build()
					));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
}
