package net.haaim.web.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.student.entity.ExamItemEntity;

public interface ExamItemRepository extends JpaRepository<ExamItemEntity, Integer>{
	/**
	 * 한 문제 내용을 조회
	 * @param examNo
	 * @param no
	 * @param itemNo
	 * @return
	 */
	public ExamItemEntity findByExamNoAndNoAndItemNo(Integer examNo, Integer no, Integer itemNo);
	
	
}
