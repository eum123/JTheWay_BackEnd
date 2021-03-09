package net.haaim.web.student.controller;

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
import net.haaim.web.student.service.StudentService;
import net.haaim.web.user.entity.UserEntity;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
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
	
	//TODO:
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "page", defaultValue = "1") Integer page
			, @RequestParam(value = "size", defaultValue = "10") Integer size
			, @RequestParam(value = "user_type", required = false) Integer userType
			, @RequestParam(value = "use_yn", required = false) Integer usage
			, @RequestParam(value = "key", required = false) String key) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");
			
			return ApiResponse.getSuccessResponse(service.search("", "", usage, pageable));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public ApiResponse regist(
			@RequestParam(value = "user_type", required=true) Integer userType, 
			@RequestParam(value = "use_yn", required=true) Integer usage,
			@RequestParam(value = "name", required=true) String name,
			@RequestParam(value = "user_id", required=true) String userId,
			@RequestParam(value = "user_pw", required=true) String password) {
		
		try {
			User user = UserHelper.getUser();
			
			return ApiResponse.getSuccessResponse(service.save(UserEntity.builder()
					.userType(userType)
					.usage(usage)
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
	
	
	@RequestMapping(value = "attendance/monthly", method = RequestMethod.GET)
	public ApiResponse monthlyAttendance(@RequestParam(value = "year") Integer year,
			@RequestParam(value = "month") Integer month) {
		return null;
	}
}
