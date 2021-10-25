package net.haaim.web.api.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.exam.entity.ItemPoolEntity;
import net.haaim.web.api.exam.repository.ItemMapper;

@RequiredArgsConstructor
@Service
public class ItemService {

	private final ItemMapper itemMapper;

	/**
	 * 문제 은행 목록 조회.
	 * @param year
	 * @param grade
	 * @param course
	 * @param mediumCategory
	 * @param useYn
	 * @param question
	 * @return
	 */
	public List<ItemPoolEntity> findAllByGradeOrCourseOrMediumCategoryOrUserYnOrQuestion(
			Integer year, Integer grade, Integer course, String mediumCategory,
			Integer useYn, String question) {

		return itemMapper.findAllByGradeOrCourseOrMediumCategoryOrUserYnOrQuestion(
				year, grade, course, mediumCategory, useYn, question);
	}
}
