package net.haaim.web.student.controller;

import java.io.File;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.haaim.web.common.User;
import net.haaim.web.common.UserHelper;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;
import net.haaim.web.student.entity.QuestionDTO;
import net.haaim.web.student.entity.ExamItemDTO;
import net.haaim.web.student.service.QuestionService;

@Slf4j
@RestController
@RequestMapping("/student/question")
public class StudentExamController {
	
	@Autowired
	private QuestionService questionService;

	
	/**
	 * 시험 출제 목록
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ApiResponse questionAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");
			
			//학생의 classNo를 조회
			
			//TODO: userID 를  student_no로 변경
			Page<QuestionDTO> result = questionService.search(null, null, pageable);

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 학생별로 문제 내용을 조회 한다.
	 * @param examNo
	 * @return
	 */
	@RequestMapping(value = "item", method = RequestMethod.GET)
	public ApiResponse questionItem(@RequestParam(value = "exam_no") Integer examNo,
			@RequestParam(value = "student_no") Integer studentNo) {
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {

			List<ExamItemDTO> result = questionService.searchItem(examNo, studentNo);

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 출제 시험의 comment 저장
	 * @param examNo
	 * @param comments
	 * @return
	 */
	@RequestMapping(value = "comments/save", method = RequestMethod.POST)
	public ApiResponse saveComments(@RequestParam(value = "exam_no") Integer examNo, 
			@RequestParam(value = "student_no") Integer studentNo,
			@RequestParam(value = "comments") String comments) {
		// 사용자의 권한을 확인
		User user = UserHelper.getUser();

		try {

			questionService.saveComments(examNo, studentNo, comments);

			return ApiResponse.getSuccessResponse(null);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	} 
	
	@RequestMapping(value = "choice/save", method = RequestMethod.POST)
	public ApiResponse saveChoiceAnswer(@RequestParam(value = "exam_no") Integer examNo, 
			@RequestParam(value = "student_no") Integer studentNo,
			@RequestParam(value = "item_no") Integer itemNo,
			@RequestParam(value = "question_no") Integer questionNo,
			@RequestParam(value = "answer") String answer) {
		
		User user = UserHelper.getUser();

		try {

			questionService.saveChoice(examNo, studentNo, questionNo, itemNo, answer);

			return ApiResponse.getSuccessResponse(null);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@RequestMapping(value = "contents/save", method = RequestMethod.POST)
	public ApiResponse saveContentsAnswer(@RequestParam(value = "exam_no") Integer examNo, 
			@RequestParam(value = "student_no") Integer studentNo,
			@RequestParam(value = "question_no") Integer questionNo,
			@RequestParam(value = "file") MultipartFile file) {
		
		
		
	    User user = UserHelper.getUser();

		try {
			
			String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
		    String basePath = rootPath + "/" + "single";
		    
		    //TODO: 파일 이름 중복 방지를 위해 새로운 이름으로 선정
		    String filePath = basePath + "/" + file.getOriginalFilename();
		    File dest = new File(filePath);
		    file.transferTo(dest); // 파일 업로드 작업 수행
		    
		    
			questionService.saveConetent(examNo, studentNo, questionNo, filePath);

			return ApiResponse.getSuccessResponse(null);

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 학생 메인의 시험 그래프 출력용 데이터
	 * @param year
	 * @param month
	 * @param studentNo
	 * @param examNo
	 * @return
	 */
	@RequestMapping(value = "monthly", method = RequestMethod.GET)
	public ApiResponse examSummary(@RequestParam(value = "year") Integer year, 
			@RequestParam(value = "month") Integer month,
			@RequestParam(value = "student_no") Integer studentNo,
			@RequestParam(value = "exam_no") Integer examNo) {
		
	    User user = UserHelper.getUser();

		try {
			return ApiResponse.getSuccessResponse(questionService.findMonthlyExam(year, month, studentNo, examNo));

		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 현재 온라인 테스트 건수
	 * @param studentNo
	 * @return
	 */
	@RequestMapping(value = "now", method = RequestMethod.GET)
	public ApiResponse examNow(
			@RequestParam(value = "student_no") Integer studentNo) {
		User user = UserHelper.getUser();

		try {
			return ApiResponse.getSuccessResponse(questionService.findExamNowCount(studentNo));
		} catch (Exception e) {
			log.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
