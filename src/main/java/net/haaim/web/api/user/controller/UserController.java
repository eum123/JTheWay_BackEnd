package net.haaim.web.api.user.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.page.SpringPageHelper;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.user.entity.CustomUserDetails;
import net.haaim.web.api.user.entity.UserEntity;
import net.haaim.web.api.user.service.CustomUserDetailService;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final CustomUserDetailService userService;
	
	/**
	 * admin > 사용자 관리.
	 * 사용자 전체 목록 조회.
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse findAll(
			@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "utype") @Nullable Integer utype,
			@RequestParam(value = "use_yn") @Nullable Integer useYn,
			@RequestParam(value = "keyword") @Nullable String keyword) {

		try {
			
			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			return HaaimApiResponse.getSuccessResponse(
					SpringPageHelper.convertSpringPage(userService.findAllByUTypeAndUseYnAndKeyword(utype, useYn, keyword)));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/** 
	 * 사용자 저장.
	 * @param userEntity
	 * @return
	 */
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(@RequestParam(value = "user") UserEntity userEntity) {
		try {
			
			return HaaimApiResponse.getSuccessResponse(userService.save(userEntity));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/** 
	 * admin에서 사용하며 클래스 등록시 선생 및 학생목록 추출 용.
	 * 페이징 없음.
	 * @param uType
	 * @return
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse all(@RequestParam(value = "u_type") Integer uType) {
		try {
			
			return HaaimApiResponse.getSuccessResponse(userService.findAllByUType(uType));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * 전체화면
	 * 로그인 되어 있는 사용자 정보.
	 * @return
	 */
	@GetMapping(value = "/info/logon", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse logonInfo() {
		try {
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			return HaaimApiResponse.getSuccessResponse(logonUser);
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	/**
	 * admin > 사용자관리.
	 * ID 중복 확인.
	 * @param id
	 * @return
	 */
	@PatchMapping(value = "/duplicate/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse checkUserId(@PathVariable(value = "id", required = true) String id) {
		try {
			return HaaimApiResponse.getSuccessResponse(userService.checkId(id));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	} 
}
