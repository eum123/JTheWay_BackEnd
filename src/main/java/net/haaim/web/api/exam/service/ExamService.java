package net.haaim.web.api.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.common.util.DateHelper;
import net.haaim.web.api.exam.entity.DailyTakeExamStatusEntity;
import net.haaim.web.api.exam.entity.ExamAverageEntity;
import net.haaim.web.api.exam.entity.ExamListEntity;
import net.haaim.web.api.exam.entity.MonthlyExamStatusEntity;
import net.haaim.web.api.exam.repository.ExamMapper;

@RequiredArgsConstructor
@Service
public class ExamService {
	
	private final ExamMapper examMapper;
	
	/**
	 * 특정 학생의 시험목록.
	 * @param studentNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<ExamListEntity> findAllByStudentNo(Integer studentNo) {
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
}
