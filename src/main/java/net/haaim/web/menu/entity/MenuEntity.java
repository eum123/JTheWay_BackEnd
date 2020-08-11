package net.haaim.web.menu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MenuEntity extends CommonEntity {
	@Id // pk
	@Column(name = "menu_code")
	@JsonProperty(value = "menu_code", access = JsonProperty.Access.WRITE_ONLY)
	private String menuCode;

	@Column(name = "menu_name")
	@JsonProperty(value = "menu_name", access = JsonProperty.Access.WRITE_ONLY)
	private String menuName;
	
	@Column(name = "parent_menu_code")
	@JsonProperty(value = "parent_menu_code", access = JsonProperty.Access.WRITE_ONLY)
	private String parentMenuCode;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int depth;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String url;

	@Column(name = "use_yn")
	@JsonProperty(value = "use_yn", access = JsonProperty.Access.WRITE_ONLY)
	private int usage = 0;

	@Builder
	public MenuEntity(String menuCode, String menuName, String parentMenuCode, int depth, String url, int usage, String inputId, Date inputDate, String updateId,
			Date updateDate) {

		super(inputId, inputDate, updateId, updateDate);

		validate(menuCode, menuName);

		this.menuCode = menuCode;
		this.menuName = menuName;
		this.parentMenuCode = parentMenuCode;
		this.depth = depth;
		this.url = url;
		this.usage = usage;

	}

	private void validate(String menuCode, String menuName) {
		Assert.hasText(menuCode, "menuCode must not be empty");
		Assert.hasText(menuName, "menuName must not be empty");
	}

}

