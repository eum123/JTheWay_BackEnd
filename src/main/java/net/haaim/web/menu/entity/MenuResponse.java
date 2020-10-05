package net.haaim.web.menu.entity;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MenuResponse {
	@JsonProperty(value = "primary", access = JsonProperty.Access.AUTO)
	private MenuEntity primaryMenu;
	
	@JsonProperty(value = "secondary", access = JsonProperty.Access.AUTO)
	private List<MenuEntity> secondaryMenu = new ArrayList<MenuEntity>();
	
	public void addSecondary(MenuEntity entity) {
		secondaryMenu.add(entity);
	}
}
