package net.haaim.web.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.student.entity.ExamUserEntity;

public interface ExamUserRepository extends JpaRepository<ExamUserEntity, Integer>{
	/**
	 * 학생별 시험 응시 정보를 구한다.
	 * @param examNo
	 * @param studentNo
	 * @return
	 */
	public ExamUserEntity findByExamNoAndStudentNo(Integer examNo, Integer studentNo);
}
