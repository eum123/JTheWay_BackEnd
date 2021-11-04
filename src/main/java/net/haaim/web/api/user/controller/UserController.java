package net.haaim.web.api.user.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;
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
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize) {

		try {
			
			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);
			
			return HaaimApiResponse.getSuccessResponse(userService.findAll());
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
}
