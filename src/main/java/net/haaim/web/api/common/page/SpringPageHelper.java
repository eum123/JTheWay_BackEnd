package net.haaim.web.api.common.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import net.haaim.web.common.request.CustomPageRequest;

public class SpringPageHelper {
	/**
	 * PageHelper용 page 를 Spring Page로 변환.
	 * @param page
	 * @return
	 */
	public static Page<?> convertSpringPage(com.github.pagehelper.Page<?> page) {

		PageRequest pageable = CustomPageRequest.of(page.getPageNum(), page.getPageSize(), "unknown");
		
		return new PageImpl(page.getResult(), pageable, page.getTotal());

	}
}
