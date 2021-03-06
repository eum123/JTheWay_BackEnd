package net.haaim.web.code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.haaim.web.code.service.GroupCodeService;
import net.haaim.web.code.service.CodeService;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;

@RestController
@RequestMapping("/code")
public class CodeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CodeService codeService;
	@Autowired
	private GroupCodeService codeGroupService;

	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ApiResponse searchAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "usage", required = false) Integer usage) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(codeService.search(pageable));
		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "usage", required = false) Integer usage, @RequestParam(value = "name") String name) {

		try {

			PageRequest pageable = CustomPageRequest.of(page, size, "no");

			return ApiResponse.getSuccessResponse(codeService.search(name, usage, pageable));
		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@RequestMapping(value = "group/all", method = RequestMethod.GET)
	public ApiResponse searchGroupCode() {

		try {
			return ApiResponse.getSuccessResponse(codeGroupService.searchAll());
		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@PostMapping(value = "save")
	public ApiResponse saveCode(@RequestParam(value = "group_code") String groupCode,
			@RequestParam(value = "code") String code, @RequestParam(value = "code_name") String codeName,
			@RequestParam(value = "use_yn") Integer usage) {

		try {
			return ApiResponse.getSuccessResponse(codeService.save(groupCode, code, codeName, usage));
		} catch (Exception e) {
			logger.error("code save error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@PostMapping(value = "group/save")
	public ApiResponse saveGroupCode(@RequestParam(value = "code") String code,
			@RequestParam(value = "code_name") String codeName) {

		try {
			return ApiResponse.getSuccessResponse(codeGroupService.save(code, codeName));
		} catch (Exception e) {
			logger.error("groupcode save error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

}
