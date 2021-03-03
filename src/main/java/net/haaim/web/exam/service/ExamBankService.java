package net.haaim.web.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.haaim.web.exam.entity.ItemPoolEntity;
import net.haaim.web.exam.repository.ItemPoolRepository;
import net.haaim.web.exam.repository.ItemPoolRepositoryJOOQ;

@Service
public class ExamBankService {
	
	@Autowired
	private ItemPoolRepository itemPoolRepo;
	
	@Autowired
	private ItemPoolRepositoryJOOQ itemPoolRepoJOOQ;
	
	public Page<ItemPoolEntity> search(Pageable pageable) {
		return itemPoolRepoJOOQ.findAll(pageable);
	}
	
	//TODO: 구현 필요
	public Page<ItemPoolEntity> search(Integer year, Integer grade, Integer course, String mediumCategory, Integer useYn, String question, PageRequest pageable) {
		
		return itemPoolRepoJOOQ.findAllByCondition(year, grade, course, mediumCategory, useYn, question, pageable);
	}
	
	public ItemPoolEntity save(ItemPoolEntity entity) {
		return itemPoolRepo.save(entity);
	}
	
	/**
	 * exam_list.exam_no에 해당하면 문제 목록 조회
	 * @param examNo
	 * @return
	 */
	public List<ItemPoolEntity> findAllByExamNo(Integer examNo) {
		return null;
	}
}
