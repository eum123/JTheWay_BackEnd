package net.haaim.web.api.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.haaim.web.api.admin.entity.DailyClassInfoEntity;
import net.haaim.web.api.admin.repository.AdminMapper;

@RequiredArgsConstructor
@Service
public class AdminService {
	private final AdminMapper adminMapper;
	
	/**
	 * admin 메인에 일별 [클래스 / 출석/ 온라인테스트 / 패스비율 / 평균점수]
	 * @return
	 */
	public List<DailyClassInfoEntity> dailyClassInfoList() {
		return adminMapper.dailyClassInfoList();
	}
}
