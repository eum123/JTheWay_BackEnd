package net.haaim.web.api.system.menu.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import net.haaim.web.api.system.menu.entity.MenuEntity;

@Mapper
public interface MenuMapper {

	@Insert("INSERT INTO MENU (menu_code, menu_name, parent_menu_code, depth, url, use_yn, sort, input_id, input_date) "
			+ "VALUES (#{menuCode}, #{menuName}, #{parentMenuCode}, #{depth}, #{url}, #{useYn}, #{sort}, #{inputId}, #{inputDate})")
	public void save(MenuEntity entity);
	
	public List<MenuEntity> findAll();
}
