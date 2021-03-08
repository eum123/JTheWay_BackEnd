package net.haaim.web.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.exam.entity.QuestionDTO;
import net.haaim.web.exam.repository.QuestionRepository;
import net.haaim.web.exam.repository.QuestionRepositoryJOOQ;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository repo;
	
	@Autowired
	private QuestionRepositoryJOOQ repoJooq;
	
	/**
	 * 출제번호에 맞는 온라인테스트 내용 조회 
	 * @param examNo
	 * @return
	 */
	public QuestionDTO findOneByExamNo(Integer examNo) {
		return repoJooq.findOneByExamNo(examNo);
	}

	/**
	 * 온라인 테스트 사용자별 목록  
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> search(Integer classNo, Integer studentNo, Pageable pageable) {
		return repoJooq.findAllByUserId(classNo, studentNo, pageable);
	}
	
	/**
	 * 온라인 테스트 사용자별 조건 검색 목록 
	 * @param year
	 * @param stare
	 * @param userId
	 * @param pageable
	 * @return
	 */
	public Page<QuestionDTO> search(Integer year, Integer stare, Integer classNo, Integer studentNo, Pageable pageable) {
		return repoJooq.findAllByYearAndStareAndUserId(year, stare, classNo, studentNo, pageable);
	}
}
