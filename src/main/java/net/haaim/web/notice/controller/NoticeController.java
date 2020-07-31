package net.haaim.web.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.haaim.web.common.request.CustomPageRequest;
import net.haaim.web.common.response.ApiResponse;
import net.haaim.web.notice.service.NoticeServiceForAdmin;
import net.haaim.web.notice.service.NoticeServiceForStudent;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NoticeServiceForStudent noticeStudent;
	private NoticeServiceForAdmin noticeAdmin;

	@RequestMapping(value = "searchAll", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size) {
		//사용자의 권한을 확인
		
		boolean isAdmin = false;
		try {

			PageRequest pageRequest = CustomPageRequest.of(page, size, "no");

			Page result = service.searchAll(pageRequest);
			if(isAdmin) {
				result = service.searchByAdmin(title, contents, pageable)
			}

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ApiResponse search(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size,
			@RequestParam(value = "title") String title, @RequestParam(value = "contents") String contents) {

		try {

			PageRequest pageRequest = CustomPageRequest.of(1, 10, "no");

			Page result = service.search(title, contents, pageRequest);

			return ApiResponse.getSuccessResponse(result);

		} catch (Exception e) {
			logger.error("search error", e);

			return ApiResponse.getErrorResponse(e);

		}
	}
}
