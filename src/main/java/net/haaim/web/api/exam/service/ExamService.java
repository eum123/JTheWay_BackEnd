package net.haaim.web.api.exam.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.common.PageConstants;
import net.haaim.web.api.exam.entity.ExamListEntity;
import net.haaim.web.api.exam.repository.ExamMapper;

@RequiredArgsConstructor
@Service
public class ExamService {
	
	private final ExamMapper examMapper;
	
	/**
	 * 학생별 문제목록 조회.
	 * @param studentNo
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<ExamListEntity> findAllByStudentNo(Integer studentNo, int pageNo, int pageSize) {
		int no = pageNo;
		if(pageNo == 0) {
			no = PageConstants.DEFAULT_PAGE_NO;
		}
		int size = pageSize;
		if(pageSize == 0) {
			size = PageConstants.DEFAULT_PAGE_SIZE;
		}
		
		//mybatis paging
		PageHelper.startPage(no, size);
		
		return examMapper.findAllByStudentNo(studentNo);
	}
}
