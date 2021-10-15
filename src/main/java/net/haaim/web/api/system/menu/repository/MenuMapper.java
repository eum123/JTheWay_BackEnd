package net.haaim.web.api.system.menu.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.haaim.web.api.system.menu.entity.MenuEntity;

@Mapper
public interface MenuMapper {

	@Insert("INSERT INTO MENU (menu_code, menu_name, parent_menu_code, depth, url, use_yn, sort, input_id, input_date) "
			+ "VALUES (#{menuCode}, #{menuName}, #{parentMenuCode}, #{depth}, #{url}, #{useYn}, #{sort}, #{inputId}, #{inputDate})")
	public void save(MenuEntity entity);
	
	/**
	 * 사용자 type에 맞는 메뉴 목록을 조회 한다.
	 * @param userType
	 * @param useYn
	 * @return
	 */
	public List<MenuEntity> findAll(@Param("user_type") Integer userType, @Param("use_yn") Integer useYn);
}
