package net.haaim.web.code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.service.CodeService;
import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;

@RestController
@RequestMapping("/code")
public class CodeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CodeService codeService;

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
}
