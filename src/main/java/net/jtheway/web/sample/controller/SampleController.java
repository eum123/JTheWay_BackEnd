package net.jtheway.web.sample.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.jtheway.web.common.response.ApiResponse;
import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SampleService service;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam("name") String name) {

		ApiResponse message = null;
		try {
			SampleEntity result = service.search(name);

			
			return ApiResponse.getSuccessResponse(result);
			
		} catch (Exception e) {
			logger.error("search error", e);
			
			return ApiResponse.getErrorResponse(e);
			
		}
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public ApiResponse search() {
		ApiResponse message = null;
		try {
			List<SampleEntity> result = service.searchAll();

			return ApiResponse.getSuccessResponse(result);
		} catch (Exception e) {
			logger.error("all error", e);
			
			return ApiResponse.getErrorResponse(e);
		}
	}
}
