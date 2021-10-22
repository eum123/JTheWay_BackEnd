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
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.system.code.entity.CodeGroupEntity;
import net.haaim.web.api.system.code.service.CodeGroupService;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RestController
@RequestMapping("/code/group")
@RequiredArgsConstructor
public class CodeGroupController {
	
	private final CodeGroupService codeGroupService;

	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(@RequestBody CodeGroupEntity entity) {

		try {
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			entity.setInputId(logonUser.getUsername());

			return HaaimApiResponse.getSuccessResponse(codeGroupService.save(entity));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse list(@RequestParam(value = "page_no", defaultValue = "1") @Nullable Integer pageNo,
			@RequestParam(value = "page_size", defaultValue = "10") @Nullable Integer pageSize,
			@RequestParam(value = "use_yn", required = false) @Nullable Integer userYn) {

		try {

			// mybatis paging
			PageHelper.startPage(pageNo, pageSize);

			return HaaimApiResponse.getSuccessResponse(codeGroupService.findAllByUseYn(userYn));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
