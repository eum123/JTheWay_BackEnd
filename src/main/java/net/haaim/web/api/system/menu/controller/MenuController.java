package net.haaim.web.api.system.menu.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.Role;
import net.haaim.web.api.common.response.HaaimApiResponse;
import net.haaim.web.api.system.menu.entity.MenuEntity;
import net.haaim.web.api.system.menu.service.MenuService;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RestController
@RequestMapping("/system/menu")
//@Api(value="menu api")
@RequiredArgsConstructor
public class MenuController {
	
	private final MenuService menuService;
	
//	@ApiOperation(
//			value="menu 저장.", 
//			response = MenuEntity.class)
//	@Operation(summary = "메뉴 저장.")
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse save(
//			@ApiParam(value="저장할 메뉴 정보.", required = true ) 
			@RequestBody MenuEntity entity ) {

		try {
			
			//TODO:
			
			return HaaimApiResponse.getSuccessResponse(null);
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse findAll() {
		
		try {
			//user 테이블에서 사용자 권한을 구한다. 
			CustomUserDetails logonUser = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			String authority = logonUser.getAuthorities().get(0).getAuthority();
			Integer userType = Role.valueOf(authority).getCode();
			
			return HaaimApiResponse.getSuccessResponse(menuService.findAll(userType, MenuEntity.VIEW));
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}

}
