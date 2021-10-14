package net.haaim.web.api.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
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
}
