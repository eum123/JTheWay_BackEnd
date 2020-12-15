package net.haaim.web.clazz.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.clazz.entity.ClassEntity;
import net.haaim.web.clazz.service.ClassService;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;

@Slf4j
@RestController
@RequestMapping("/lessons/class")
public class ClassController {
	@Autowired
	private ClassService service;
	
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
			@RequestParam(value = "class_name") String className,
			@RequestParam(value = "day_time") String dayTime,
			@RequestParam(value = "curriculum_list[]") Integer[] curriculumList,
			@RequestParam(value = "student_list[]") Integer[] studentList,
			@RequestParam(value = "textbook") String textBook,
			@RequestParam(value = "teacher_no") Integer teacherNo,
			@RequestParam(value = "start_date") String startDate,
			@RequestParam(value = "end_date") String endDate,
			@RequestParam(value = "description") String description
			) {

		try {
			
			User user = UserHelper.getUser();
			
			ClassEntity classEntity = ClassEntity.builder()
					.year(year)
					.className(className)
					.dayTime(dayTime)
					.textBook(textBook)
					.teacherNo(teacherNo)
					.description(description)
					.startDate(startDate)
					.endDate(endDate)
					.inputDate(new Date())
					.inputId(user.getId())
					.build();

			return ApiResponse.getSuccessResponse(service.regist(user, classEntity, curriculumList, studentList));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
