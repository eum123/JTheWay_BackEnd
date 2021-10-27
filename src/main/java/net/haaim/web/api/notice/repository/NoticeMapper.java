package net.haaim.web.api.notice.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import net.haaim.web.api.notice.entity.NoticeEntity;

@Mapper
public interface NoticeMapper {
	
	@Insert("INSERT INTO notice (title, contents, state, input_id, input_date) "
			+ "VALUES (#{title}, #{contents}, #{state}, #{inputId}, NOW())")
	@Options(useGeneratedKeys = true, keyProperty = "no")
	Integer save(NoticeEntity entity);
	
	/**
	 * 입력된 조건으로 목록 조회.
	 * @param state
	 * @param title
	 * @param contents
	 * @return
	 */
	Page<NoticeEntity> findAllByStateAndTitleOrContens(
			@Param("state") Integer state
			, @Param("title") String title
			, @Param("contents") String contents);
}
