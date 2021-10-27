package net.haaim.web.api.system.code.controller;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.page.SpringPageHelper;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.system.code.entity.CodeEntity;
import net.haaim.web.api.system.code.service.CodeService;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RestController
@RequestMapping("/code")
@RequiredArgsConstructor
public class CodeController {

	private final CodeService codeService;

	/**
	 * 코드 저장.
	 * @param entity
	 * @return
	 */
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(@RequestBody CodeEntity entity) {

		try {
			CustomUserDetails logonUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			entity.setInputId(logonUser.getUsername());

			return HaaimApiResponse.getSuccessResponse(codeService.save(entity));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}

	/** 
	 * 코드 목록 전체 조회.
	 * @param pageNo
	 * @param pageSize
	 * @param userYn
	 * @return
	 */
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse list(@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "code_name") @Nullable String codeName,
			@RequestParam(value = "use_yn", required = false, defaultValue = "1") @Nullable Integer userYn) {

		try {

			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);

			return HaaimApiResponse
					.getSuccessResponse(SpringPageHelper.convertSpringPage(codeService.findAllByCodeNameAndUseYn(codeName, userYn)));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}

}
