package net.haaim.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;
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
}
