package net.haaim.web.code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.haaim.web.code.entity.CodeEntity;
import net.haaim.web.code.service.CodeService;
import net.haaim.web.common.response.ApiResponse;

@RestController
@RequestMapping("/code")
public class CodeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CodeService codeService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "groupcode") String groupCode,
			@RequestParam(required = false, value = "usage") Integer usage) {

		try {
			int useYn = 0;
			if (usage == null) {
				useYn = CodeEntity.VIEW;
			} else {
				useYn = usage.intValue();
			}

			return ApiResponse.getSuccessResponse(codeService.search(groupCode, useYn));
		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
