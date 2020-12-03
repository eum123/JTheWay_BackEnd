package net.haaim.web.clazz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.clazz.service.CurriculumService;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;

@Slf4j
@RestController
@RequestMapping("/lessons/curriculum")
public class CurriculumController {
	@Autowired
	private CurriculumService service;
	
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
	public ApiResponse search(
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "grade", required = false) Integer grade,
			@RequestParam(value = "course", required = false) Integer course,
			@RequestParam(value = "large_category", required = false) String largeCategory,
			@RequestParam(value = "medium_category", required = false) String mediumCategory,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			) {

		try {
			
			User user = UserHelper.getUser();

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(service.search(year, grade, course, largeCategory, pageable));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public ApiResponse regist(
			@RequestParam(value = "year") Integer year,
			@RequestParam(value = "grade") Integer grade,
			@RequestParam(value = "course") Integer course,
			@RequestParam(value = "large_category") String largeCategory,
			@RequestParam(value = "medium_category") String mediumCategory,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			) {

		try {
			
			User user = UserHelper.getUser();

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(service.regist(user, year, grade, course, largeCategory, mediumCategory));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
