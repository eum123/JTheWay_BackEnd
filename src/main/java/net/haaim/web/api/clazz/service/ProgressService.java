package net.haaim.web.api.clazz.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.clazz.entity.ProgressListResponse;
import net.haaim.web.api.clazz.repository.ProgressMapper;

/**
 * 진도 서비스.
 * 
 * @author a28097823
 *
 */
@RequiredArgsConstructor
@Service
public class ProgressService {
	private final ProgressMapper mapper;

	/**
	 * 진도 목록.
	 * 
	 * @param year
	 * @param grade
	 * @param className
	 * @param memberId
	 * @param authorize
	 * @param uType
	 * @param ownerId
	 * @return
	 */
	public Page<ProgressListResponse> findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(Integer year, Integer grade,
			String className, String memberId, Integer uType, String ownerId) {
		// TODO: 쿼리 확정 필요.
		return mapper.findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(year, grade, className, memberId, uType,
				ownerId);
	}
}
