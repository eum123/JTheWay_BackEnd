package net.haaim.web.api.clazz.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.clazz.service.ProgressService;
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
@RequestMapping("/progress")
@RequiredArgsConstructor
public class ProgressController {
	private final ProgressService progressService;
	
	/**
	 * admin > 진도관리.
	 * 진도 목록 조회.
	 * @param year
	 * @param grade
	 * @param className
	 * @param memberId
	 * @return
	 */
	@GetMapping(value = "/progress/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse progressList(
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "year") @Nullable Integer year,
			@RequestParam(value = "grade") @Nullable Integer grade,
			@RequestParam(value = "class_name") @Nullable String className,
			@RequestParam(value = "member_id") @Nullable String memberId) {
		try {
			
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			// TODO: 쿼리 확정 필요.
			return HaaimApiResponse.getSuccessResponse(SpringPageHelper.convertSpringPage(
					progressService.findAllByYearAndGradeAndClassNameAndMemberIdAndOwner(
							year, grade, className, memberId, logonUser.getUType(), logonUser.getUsername())));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
