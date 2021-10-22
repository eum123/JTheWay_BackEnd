package net.haaim.web.api.admin.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.admin.service.AdminService;
import net.haaim.web.api.common.response.HaaimApiResponse;

@Slf4j
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	/**
	 * admin 메인에 일별 [클래스 / 출석/ 온라인테스트 / 패스비율 / 평균점수]
	 * @return
	 */
	@PostMapping(value = "/class/info/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public HaaimApiResponse dailyClassInfoList() {
		try {
			
			return HaaimApiResponse.getSuccessResponse(adminService.dailyClassInfoList());
		} catch (Exception e) {
			log.error("search error", e);
			return HaaimApiResponse.getErrorResponse(e);

		}
	}
}
