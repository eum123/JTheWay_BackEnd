package net.haaim.web.api.clazz.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.clazz.service.ClassService;
import net.haaim.web.api.common.response.HaaimApiResponse;

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
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse findAll(
			@RequestParam(value = "status", defaultValue = "1") @Nullable Integer status) {
		try {
			return HaaimApiResponse.getSuccessResponse(classService.findAllStatus(status));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
