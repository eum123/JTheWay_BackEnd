package net.jtheway.web.sample.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.jtheway.web.common.response.ApiResponseMessage;
import net.jtheway.web.sample.entity.SampleEntity;
import net.jtheway.web.sample.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {

	
	@Autowired
	private SampleService service;

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ResponseEntity<ApiResponseMessage> search(@RequestParam("name") String name) {

		ApiResponseMessage message = null;
		try {
			SampleEntity result = service.search(name);

			if (result == null) {
				// empty
				message = new ApiResponseMessage(HttpStatus.OK, "", "", "");
			} else {
				message = new ApiResponseMessage(HttpStatus.OK, result, "", "");
			}
			return new ResponseEntity<ApiResponseMessage>(message, message.getHttpStatus());
		} catch (Exception e) {
			message = new ApiResponseMessage(e);
			return new ResponseEntity<ApiResponseMessage>(message, message.getHttpStatus());
		}
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public ResponseEntity<ApiResponseMessage> search() {
		ApiResponseMessage message = null;
		try {
			List<SampleEntity> result = service.searchAll();

			if (result == null) {
				// empty
				message = new ApiResponseMessage(HttpStatus.OK, "", "", "");
			} else {
				message = new ApiResponseMessage(HttpStatus.OK, result, "", "");
			}
			return new ResponseEntity<ApiResponseMessage>(message, message.getHttpStatus());
		} catch (Exception e) {
			message = new ApiResponseMessage(e);
			return new ResponseEntity<ApiResponseMessage>(message, message.getHttpStatus());
		}
	}
}
