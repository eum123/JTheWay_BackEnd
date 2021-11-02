package net.haaim.web.api.clazz.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.clazz.entity.ClassSaveRequest;
import net.haaim.web.api.clazz.service.ClassService;
import net.haaim.web.api.common.page.SpringPageHelper;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RestController
@RequestMapping("/class")
@RequiredArgsConstructor
public class ClassController {
	
	private static Integer TERM_WEEKLY = 1;
	
	private final ClassService classService;

	/**
	 * 일별 출결 현황.
	 * @param term
	 * @return
	 */
	@GetMapping(value = "/daily/attendance", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse dailyClassAttendance() {
		try {
			
			return HaaimApiResponse.getSuccessResponse(classService.dailyClassAttendance());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * class 목록 조회.
	 * @param status
	 * @return
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse findAll(
			@RequestParam(value = "status", defaultValue = "1") @Nullable Integer status) {
		try {
			return HaaimApiResponse.getSuccessResponse(classService.findAllStatus(status));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	/**
	 * admin > 수업관리.
	 *  class 목록 
	 * @param pageNo
	 * @param pageSize
	 * @param year
	 * @param grade
	 * @param course
	 * @param largeCategory
	 * @param status
	 * @return
	 */
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse findAllByYearAndGradeAndCourseAndLargeCategory(
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "year") @Nullable Integer year,
			@RequestParam(value = "grade") @Nullable String grade,
			@RequestParam(value = "course") @Nullable String course,
			@RequestParam(value = "large_category") @Nullable String largeCategory,
			@RequestParam(value = "status") @Nullable Integer status
			) {
		try {
			return HaaimApiResponse.getSuccessResponse(SpringPageHelper.convertSpringPage(classService.findAllByYearAndGradeAndCourseAndLargeCategorAndStatus(
					year, grade, course, largeCategory, status )));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	
	
	/**
	 * admin > 수업관리
	 * class 등록.
	 * @param entity
	 * @return
	 */
	@PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(@RequestBody ClassSaveRequest entity) {
		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return HaaimApiResponse.getSuccessResponse(
					classService.save(entity, logonUser.getUsername()));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
