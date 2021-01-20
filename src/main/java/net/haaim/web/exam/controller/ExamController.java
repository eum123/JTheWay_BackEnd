package net.haaim.web.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import net.haaim.web.exam.entity.ItemPoolEntity;
import net.haaim.web.exam.service.ExamBankService;

@Slf4j
@RestController
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamBankService examBankService;

	@RequestMapping(value = "bank/all", method = RequestMethod.GET)
	public ApiResponse bankAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");
			
			Page<ItemPoolEntity> result = examBankService.search(pageable);

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@RequestMapping(value = "bank/search", method = RequestMethod.GET)
	public ApiResponse bankSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "year", required = false) Integer year,
			@RequestParam(value = "grade", required = false) Integer grade,
			@RequestParam(value = "course", required = false) Integer course,
			@RequestParam(value = "medium_category", required = false) String mediumCategory,
			@RequestParam(value = "use_yn", required = false) Integer useYn,
			@RequestParam(value = "question", required = false) String question) {

		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");
			
			Page result = examBankService.search(year, grade, course, mediumCategory, useYn, question, pageable);

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "bank/regist", method = RequestMethod.POST)
	public ApiResponse bankRegist(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "contents", required = false) String contents) {
		
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();
		
		try {
			
			examBankService.save(null);
			
			return ApiResponse.getSuccessResponse(null);
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);
		}
	}
}
