package net.haaim.web.api.exam.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.exam.service.ExamService;

@Slf4j
@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
	
	private static Integer TERM_WEEKLY = 1;
	
	private final ExamService examService;

	/**
	 * 기간별 클래스 시험 평균.
	 * @param term
	 * @return
	 */
	@PostMapping(value = "/class/average", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse classAverage(@RequestParam(value = "term", defaultValue = "1") @Nullable Integer term) {
		try {
			
			return HaaimApiResponse.getSuccessResponse(examService.classAverageInWeekly());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	@PostMapping(value = "/class/take/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse dailyTakeExamStatus() {
		try {
			
			return HaaimApiResponse.getSuccessResponse(examService.dailyTakeExamStatus());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
