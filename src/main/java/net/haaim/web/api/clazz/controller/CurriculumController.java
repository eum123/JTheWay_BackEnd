package net.haaim.web.api.clazz.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.clazz.entity.CurriculumEntity;
import net.haaim.web.api.clazz.service.CurriculumService;
import net.haaim.web.api.common.page.SpringPageHelper;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.user.entity.CustomUserDetails;

/**
 * 진도관리.
 * @author a28097823
 *
 */
@Slf4j
@RestController
@RequestMapping("/curriculum")
@RequiredArgsConstructor
public class CurriculumController {
	private final CurriculumService curriculumService;
	
	/**
	 * admin > 커리큘럼 관리.
	 * 커리큘럼 목록 조회.
	 * @param year
	 * @param grade
	 * @param course
	 * @param largeCategory
	 * @param mediumCategory
	 * @return
	 */
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse progressList(
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "year") @Nullable Integer year,
			@RequestParam(value = "grade") @Nullable String grade,
			@RequestParam(value = "course") @Nullable String course,
			@RequestParam(value = "large_category") @Nullable String largeCategory,
			@RequestParam(value = "medium_category") @Nullable String mediumCategory
			) {
		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			return HaaimApiResponse.getSuccessResponse(SpringPageHelper.convertSpringPage(
					curriculumService.findAllByYearAndGradeAndCourseAndLargeCategoryAndMediumCateogry(
							year, grade, course, largeCategory, mediumCategory)));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * admin > 커리큘럼관리.
	 * 커리큘럼 등록.
	 * @param entity
	 * @return
	 */
	@PutMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(@RequestBody CurriculumEntity entity) {
		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			entity.setInputId(logonUser.getUsername());
			
			return HaaimApiResponse.getSuccessResponse(curriculumService.save(entity));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
