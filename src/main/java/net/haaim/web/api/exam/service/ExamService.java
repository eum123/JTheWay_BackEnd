package net.haaim.web.api.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.ClassEntity;
import net.haaim.web.api.clazz.entity.CurriculumEntity;
import net.haaim.web.api.clazz.repository.ClassMapper;
import net.haaim.web.api.clazz.repository.CurriculumMapper;
import net.haaim.web.api.common.util.DateHelper;
import net.haaim.web.api.exam.entity.DailyTakeExamStatusEntity;
import net.haaim.web.api.exam.entity.ExamAverageEntity;
import net.haaim.web.api.exam.entity.ExamItemEntity;
import net.haaim.web.api.exam.entity.ExamListResponse;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;
import net.haaim.web.api.exam.entity.OnlineQuestionResponse;
import net.haaim.web.api.exam.entity.OnlineQuestionSaveRequest;
import net.haaim.web.api.exam.repository.ExamMapper;

@RequiredArgsConstructor
@Service
public class ExamService {
	
	private final ExamMapper examMapper;
	private final ClassMapper classMapper;
	private final CurriculumMapper curriculumMapper;
	
	/**
	 * 특정 학생의 시험목록.
	 * @param studentNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<ExamListResponse> findAllByStudentNo(Integer studentNo) {
		return examMapper.findAllByStudentNo(studentNo);
	}
	
	/**
	 * 특정 학생의 월별 시험 상태.
	 * @param studentNo
	 * @return
	 */
	public MonthlyExamStatusEntity monthlyExamStatus(Integer studentNo) {
		return examMapper.monthlyExamStatus(studentNo);
	}
	
	/**
	 * 주단위 학급별 시험 평균.
	 * @return
	 */
	public List<ExamAverageEntity> classAverageInWeekly() {
		//주 첫번재 일자 구하기.
		String startDate = DateHelper.getStartDateByWeekly();
		return examMapper.classAverageInWeekly(startDate);
	}
	
	/**
	 * 일자별 시험 응시 현황.
	 * @return
	 */
	public List<DailyTakeExamStatusEntity> dailyTakeExamStatus() {
		return examMapper.dailyTakeExamStatus();
	}
	
	/**
	 * 학생명 문제 내용.
	 * @param classNo
	 * @param studentNo
	 * @param examNo
	 * @return
	 */
	public OnlineQuestionResponse findAllByStudentNoAndExamNo(Integer classNo, Integer studentNo, Integer examNo) {
		
		//select exam_list
		List<ExamItemEntity> items = examMapper.findAllByStudentNoAndExamNo(studentNo, examNo);
		
		//select class
		ClassEntity classEntity = classMapper.findOneByClassNo(classNo);
		
		//select curriculum
		CurriculumEntity curriculumEntity = curriculumMapper.findTopOneByClassNo(classNo);
		
		
		return OnlineQuestionResponse.builder()
				.classNo(classEntity.getClassNo())
				.className(classEntity.getClassName())
				.grade(curriculumEntity.getGrade())
				.course(curriculumEntity.getCourse())
				.largeCategory(curriculumEntity.getLargeCategory())
				.mediumCategory(curriculumEntity.getMediumCategory())
				.list(items)
				.build();
	}
	
	/**
	 * online 시험 저장.
	 */
	public OnlineQuestionSaveRequest saveOnlineQuestion() {
		//자동 채점인 경우.
		
		
		return null;
	}
}
