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
import net.haaim.web.student.entity.SchoolExamEntity;
import net.haaim.web.student.service.SchoolExamService;

@Slf4j
@RestController
@RequestMapping("/student/school/exam/")
public class SchoolExamController {
	@Autowired
	private SchoolExamService service;
	
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ApiResponse searchAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size
			, @RequestParam(value = "student_no", defaultValue = "10") Integer studentNo) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(service.search(studentNo, pageable));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	
	
	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public ApiResponse regist(
			@RequestParam(value = "year", required=true) Integer year, 
			@RequestParam(value = "student_no", required=true) Integer studentNo,
			@RequestParam(value = "term", required=true) String term,
			@RequestParam(value = "exam", required=true) String exam,
			@RequestParam(value = "score", required=true) String score,
			@RequestParam(value = "descrition", required=false) String description) {
		
		try {
			// 사용자의 권한을 확인
			User user = UserHelper.getUser();
			
			
			return ApiResponse.getSuccessResponse(service.save(SchoolExamEntity.builder()
					.year(year)
					.studentNo(studentNo)
					.term(term)
					.exam(exam)
					.score(score)
					.description(description)
					.inputDate(new Date())
					.inputId(user.getId())
					.build()
					));
		} catch (Exception e) {
			log.error("save error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
}
