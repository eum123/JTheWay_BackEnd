package net.haaim.web.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.haaim.web.menu.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity, String>{
	List<MenuEntity> findByUsageOrderByMenuCodeAndParentMenuCode(int usage);
}
