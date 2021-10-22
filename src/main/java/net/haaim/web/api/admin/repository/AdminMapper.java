package net.haaim.web.api.admin.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.haaim.web.api.admin.entity.DailyClassInfoEntity;

@Mapper
public interface AdminMapper {
	/**
	 * admin 메인에 일별 [클래스 / 출석/ 온라인테스트 / 패스비율 / 평균점수]
	 * @return
	 */
	List<DailyClassInfoEntity> dailyClassInfoList();
}
