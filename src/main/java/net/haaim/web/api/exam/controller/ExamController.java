package net.haaim.web.api.exam.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.exam.service.ExamService;
import net.haaim.web.api.exam.service.ItemService;

@Slf4j
@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {
	
	private static Integer TERM_WEEKLY = 1;
	
	private final ExamService examService;
	private final ItemService itemService;

	/**
	 * 기간별 클래스 시험 평균.
	 * @param term
	 * @return
	 */
	@GetMapping(value = "/class/average", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse classAverage(@RequestParam(value = "term", defaultValue = "1") @Nullable Integer term) {
		try {
			
			return HaaimApiResponse.getSuccessResponse(examService.classAverageInWeekly());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 일자별 응시 현황.
	 * @return
	 */
	@GetMapping(value = "/class/take/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse dailyTakeExamStatus() {
		try {
			
			return HaaimApiResponse.getSuccessResponse(examService.dailyTakeExamStatus());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 문제 은행 목록 조회.
	 * @param pageNo
	 * @param pageSize
	 * @param year
	 * @param grade
	 * @param course
	 * @param mediumCategory
	 * @param useYn
	 * @param question
	 * @return
	 */
	@GetMapping(value = "/item/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse itemList(@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "grade", required = false) Integer grade,
			@RequestParam(value = "course", required = false) Integer course,
			@RequestParam(value = "medium_category", required = false) String mediumCategory,
			@RequestParam(value = "use_yn", required = false) Integer useYn,
			@RequestParam(value = "question", required = false) String question) {
		try {
				
			return HaaimApiResponse.getSuccessResponse(itemService.findAllByGradeOrCourseOrMediumCategoryOrUserYnOrQuestion(
					year, grade, course, mediumCategory, useYn, question));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
