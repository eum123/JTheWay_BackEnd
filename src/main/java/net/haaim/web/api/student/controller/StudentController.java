package net.haaim.web.api.student.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.exam.service.ExamService;
import net.haaim.web.api.student.service.StudentService;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
	private final ExamService examService;

	/**
	 * 월별 출석 현황
	 * @param year
	 * @param month
	 * @param studentNo
	 * @return
	 */
	@GetMapping(value = "/monthly/attendance/status/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse monthlyAttendanceStatus(
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@RequestParam(value = "year") @Nullable Integer baseYear,
			@RequestParam(value = "month") @Nullable Integer baseMonth ) {

		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return HaaimApiResponse.getSuccessResponse(studentService.monthlyAttendanceStatus(studentNo, baseYear, baseMonth));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	@GetMapping(value = "/monthly/exam/status/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse monthlyOnlineStatus(
			@PathVariable(value = "student_no", required = true) Integer studentNo
			) {
		
		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return HaaimApiResponse.getSuccessResponse(examService.monthlyExamStatus(studentNo));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	@GetMapping(value = "/monthly/schedule/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse monthlySchedule(
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@RequestParam(value = "month", required = true) Integer baseMonth
			) {
		
		//TODO : 쿼리 확정 후 구현.
		
		return HaaimApiResponse.getErrorResponse(new Exception("구현 필요."));
	}
	
	@GetMapping(value = "/exam/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse examList(
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize
			) {
		
		try {
			
			//mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			return HaaimApiResponse.getSuccessResponse(examService.findAllByStudentNo(studentNo));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
