package net.haaim.web.api.system.menu.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.response.ApiResponse;
import net.haaim.web.api.system.menu.entity.MenuEntity;
import net.haaim.web.api.system.menu.service.MenuService;

@Slf4j
@RestController
@RequestMapping("/system/menu")
@Api(value="menu api")
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
	@ApiOperation(
			value="menu 저장.", 
			response = MenuEntity.class)
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse save(
			@ApiParam(value="저장할 메뉴 정보.", required = true ) 
			@RequestBody MenuEntity entity ) {

		try {
			
			return ApiResponse.getSuccessResponse(null);
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}
	
	@ApiOperation(
			value="메뉴 전체 목록 조회.", 
			response = MenuEntity.class)
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse findAll(
			@ApiParam(value="id", required = true ) 
			@PathVariable(value = "id", required = true) String id) {
		
		try {
			//user 테이블에서 사용자 권한을 구한다. 
			
			return ApiResponse.getSuccessResponse(menuService.findAll());
		} catch (Exception e) {
			log.error("search error", e);
			return ApiResponse.getErrorResponse(e);

		}
	}

}
