package net.haaim.web.menu.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MenuContentResponse {
	@JsonProperty(value = "menu", access = JsonProperty.Access.AUTO)
	private MenuEntity entity;
	
	@JsonProperty(value = "user_types", access = JsonProperty.Access.AUTO)
	private List<String> userTypes = new ArrayList<String>();
	
	public void setUserTypes(String userTypesString) {
		userTypes = new ArrayList<String>();
		
		String[] types = userTypesString.split("");
		Arrays.asList(types).stream().filter(x -> !x.equals("|")).forEach(x -> userTypes.add(x));
		
	}
	
	public void setMenuEntity(String menuEntityString) {
		//SELECT parent_menu_code, menu_code, menu_name, url,
		//순으로 되어 있으므로 쿼리의 순서 변경시 수정 해야됨.
		
		String[] values = menuEntityString.split(",");
		this.entity = MenuEntity.builder()
			.parentMenuCode(values[0].trim())
			.menuCode(values[1].trim())
			.menuName(values[2].trim())
			.url(values[3].trim())
			.build();
	}
}
