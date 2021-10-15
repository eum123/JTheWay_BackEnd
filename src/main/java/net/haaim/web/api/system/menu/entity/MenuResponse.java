package net.haaim.web.api.system.menu.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class MenuResponse {
	
	private MenuEntity primary;
	
	private List<MenuEntity> secondary = new ArrayList<MenuEntity>();
	
	public void addSecondary(MenuEntity entity) {
		secondary.add(entity);
	}
}
