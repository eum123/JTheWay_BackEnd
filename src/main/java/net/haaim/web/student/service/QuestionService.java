package net.haaim.web.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.student.entity.AnswerSheetEntity;
import net.haaim.web.student.entity.ExamItemDTO;
import net.haaim.web.student.entity.ExamItemEntity;
import net.haaim.web.student.entity.ExamNowCountDTO;
import net.haaim.web.student.entity.ExamUserEntity;
import net.haaim.web.student.entity.MonthlyExamDTO;
import net.haaim.web.student.entity.QuestionDTO;
import net.haaim.web.student.repository.AnswerSheetRepository;
import net.haaim.web.student.repository.ExamItemRepository;
import net.haaim.web.student.repository.ExamUserRepository;
import net.haaim.web.student.repository.MonthlyExamRepositoryJOOQ;
import net.haaim.web.student.repository.QuestionItemRepositoryJOOQ;
import net.haaim.web.student.repository.QuestionRepository;
import net.haaim.web.student.repository.QuestionRepositoryJOOQ;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repo;

	@Autowired
	private QuestionRepositoryJOOQ repoJooq;

	@Autowired
	private QuestionItemRepositoryJOOQ itemRepoJooq;

	@Autowired
	private ExamUserRepository examUserRepo;

	@Autowired
	private ExamItemRepository examItemRepo;
	
	@Autowired
	private AnswerSheetRepository answerSheetRepo;
	
	@Autowired
	private MonthlyExamRepositoryJOOQ monthlyExamRepo;

	/**
	 * 출제번호에 맞는 온라인테스트 내용 조회
	 * 
	 * @param examNo
	 * @return
	 */
	public QuestionDTO findOneByExamNo(Integer examNo) {
		return repoJooq.findOneByExamNo(examNo);
	}

	/**
	 * 온라인 테스트 사용자별 목록
	 * 
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> search(Integer classNo, Integer studentNo, Pageable pageable) {
		return repoJooq.findAllByUserId(classNo, studentNo, pageable);
	}

	/**
	 * 온라인 테스트 사용자별 조건 검색 목록
	 * 
	 * @param year
	 * @param stare
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> search(Integer year, Integer stare, Integer classNo, Integer studentNo,
			Pageable pageable) {
		return repoJooq.findAllByYearAndStareAndUserId(year, stare, classNo, studentNo, pageable);
	}

	/**
	 * 학생별 문제 목록
	 * 
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public List<ExamItemDTO> searchItem(Integer examNo, Integer studentNo) {

		return itemRepoJooq.findByExamNoAndStudentNo(examNo, studentNo);
	}

	/**
	 * 시험 문제에 대한 comments 를 저장한다.
	 * 
	 * @param examNo
	 * @param studentNo
	 * @param comments
	 * @return
	 */
	public ExamUserEntity saveComments(Integer examNo, Integer studentNo, String comments) {
		ExamUserEntity entity = ExamUserEntity.builder().examNo(examNo).studentNo(studentNo).comments(comments).build();

		return examUserRepo.save(entity);
	}

	/**
	 * 객관식 답 처리
	 * @param examNo
	 * @param studentNo
	 * @param questionNo
	 * @param itemNo
	 * @param answer
	 */
	@Transactional
	public void saveChoice(Integer examNo, Integer studentNo, Integer questionNo, Integer itemNo, String answer) {
		//문제에 대한 정답을 조회
		ExamItemEntity examItemEntity = examItemRepo.findByExamNoAndNoAndItemNo(examNo, questionNo, itemNo);
		
		//문제 답 저장	
		answerSheetRepo.save(AnswerSheetEntity.builder()
				.examNo(examNo)
				.studentNo(studentNo)
				.questionNo(questionNo)
				.answer(answer)
				.build());
		
		//채점
		boolean isCorrect = false;
		if(answer.trim().equals(examItemEntity.getAnswer().trim())) {
			isCorrect = true;
		}
		
		//점수 변경
		if(isCorrect) {
			ExamUserEntity examUserEntity = examUserRepo.findByExamNoAndStudentNo(examNo, studentNo);
			examUserRepo.save(ExamUserEntity.builder()
					.examNo(examNo)
					.studentNo(studentNo)
					.status(1)
					.score(examUserEntity.getScore() + 1)
					.build());
		}
		
	}

	/**
	 * 주관식 답 처리
	 * @param examNo
	 * @param studentNo
	 * @param questionNo
	 * @param filePath
	 */
	public void saveConetent(Integer examNo, Integer studentNo, Integer questionNo, String filePath) {
		//문제 답 저장	
		answerSheetRepo.save(AnswerSheetEntity.builder()
				.examNo(examNo)
				.studentNo(studentNo)
				.questionNo(questionNo)
				.filePath(filePath)
				.build());
	}
	
	/**
	 * 학생 시험 현황 그래프
	 * @param year
	 * @param month
	 * @param studentNo
	 * @param examNo
	 * @return
	 */
	public MonthlyExamDTO findMonthlyExam(Integer year, Integer month, Integer studentNo, Integer examNo) {
		return monthlyExamRepo.findMonthlyExam(year, month, studentNo, examNo);
	}
	
	/**
	 * 온라인 테스트 미진행 건수 조회
	 * @param studentNo
	 * @return
	 */
	public ExamNowCountDTO findExamNowCount(Integer studentNo) {
		return repoJooq.findExamNowCount(studentNo);
	}
}
