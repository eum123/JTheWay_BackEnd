package net.haaim.web.api.user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.HaaimApiResponse;

@Slf4j
@RestController
@RequestMapping("/user")
//@Api(value="user api")
@RequiredArgsConstructor
public class UserController {
//	@ApiOperation(
//			value="로그인.", 
//			response = MenuEntity.class)
	@PostMapping(value = "/login1", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse login(
//			@ApiParam(value="user_name", required = true ) 
			@PathVariable(value = "user_name", required = true) String userName,
//			@ApiParam(value="password", required = true ) 
			@PathVariable(value = "password", required = true) String password) {

		try {
			
			//TODO:
			
			return HaaimApiResponse.getSuccessResponse(null);
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
