package net.haaim.web.api.student.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.PageConstants;
import net.haaim.web.api.common.response.ApiResponse;
import net.haaim.web.api.exam.entity.ExamListEntity;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;
import net.haaim.web.api.exam.service.ExamService;
import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;
import net.haaim.web.api.student.service.StudentService;

@Slf4j
@RestController
@RequestMapping("/student")
@Api(value="학생 관련 api")
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
	@ApiOperation(
			value="학생의 월별 출석 현황.", 
			response = MonthlyAttendanceStatusEntity.class)
	@GetMapping(value = "/monthly/attendance/status/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse monthlyAttendanceStatus(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="기준 년도.", required = false ) 
			@RequestParam(value = "year") @Nullable Integer baseYear,
			@ApiParam(value="기준 월.", required = false ) 
			@RequestParam(value = "month") @Nullable Integer baseMonth ) {

		try {
			
			//User user = UserHelper.getUser();
			
			return ApiResponse.getSuccessResponse(studentService.monthlyAttendanceStatus(studentNo, baseYear, baseMonth));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@ApiOperation(
			value="학생의 월별 온라인 시험 현황.", 
			response = MonthlyExamStatusEntity.class)
	@GetMapping(value = "/monthly/exam/status/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse monthlyOnlineStatus(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo
			) {
		
		try {
			return ApiResponse.getSuccessResponse(examService.monthlyExamStatus(studentNo));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@ApiOperation(
			value="학생의 월별 수업 일정.", 
			response = MonthlyExamStatusEntity.class)
	@GetMapping(value = "/monthly/schedule/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse monthlySchedule(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="기준 월.", required = true ) 
			@RequestParam(value = "month", required = true) Integer baseMonth
			) {
		
		//TODO : 쿼리 확정 후 구현.
		
		return ApiResponse.getErrorResponse(new Exception("구현 필요."));
	}
	
	@ApiOperation(
			value="학생의 온라인 테스트 목록.", 
			response = ExamListEntity.class)
	@GetMapping(value = "/exam/{student_no}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse examList(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="페이지 번호.", defaultValue = "1" ) 
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@ApiParam(value="페이지 당 건수.", defaultValue = "10" ) 
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize
			) {
		
		try {
			
			//mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			return ApiResponse.getSuccessResponse(examService.findAllByStudentNo(studentNo));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
}
