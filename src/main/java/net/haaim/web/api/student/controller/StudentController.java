package net.haaim.web.api.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.ApiResponse;
import net.haaim.web.api.exam.service.ExamService;
import net.haaim.web.api.student.entity.MonthlyAttendanceStatusEntity;
import net.haaim.web.api.student.entity.MonthlyExamStatusEntity;
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
	@GetMapping(value = "/monthly/attendance/status/{}")
	public ApiResponse monthlyAttendance(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="기준 년도.", required = false ) 
			@RequestParam(value = "year") Integer baseYear,
			@ApiParam(value="기준 월.", required = false ) 
			@RequestParam(value = "month") Integer baseMonth ) {

		try {
			
			//User user = UserHelper.getUser();
			
			return ApiResponse.getSuccessResponse(studentService.monthlyAttendance(studentNo, baseYear, baseMonth));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@ApiOperation(
			value="학생의 월별 온라인 시험 현황.", 
			response = MonthlyExamStatusEntity.class)
	@GetMapping(value = "/monthly/exam/status/{}")
	public ApiResponse monthlyOnline(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="기준 월.", required = true ) 
			@RequestParam(value = "month", required = true) Integer baseMonth
			) {
		
		//TODO : 쿼리 확정 후 구현.
		
		return ApiResponse.getErrorResponse(new Exception("구현 필요."));
	}
	
	@ApiOperation(
			value="학생의 월별 수업 일정.", 
			response = MonthlyExamStatusEntity.class)
	@GetMapping(value = "/monthly/schedule/{}")
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
			response = MonthlyExamStatusEntity.class)
	@GetMapping(value = "/exam/{}")
	public ApiResponse examList(
			@ApiParam(value="학생 번호.", required = true ) 
			@PathVariable(value = "student_no", required = true) Integer studentNo,
			@ApiParam(value="페이지 번호.", required = true ) 
			@RequestParam(value = "page_no", required = true) Integer pageNo,
			@ApiParam(value="페이지 당 건수.", required = true ) 
			@RequestParam(value = "page_size", required = true) Integer pageSize
			) {
		
		try {
			
			//User user = UserHelper.getUser();
			
			return ApiResponse.getSuccessResponse(examService.findAllByStudentNo(studentNo, pageNo, pageSize));
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
}
