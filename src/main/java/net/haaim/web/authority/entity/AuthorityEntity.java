package net.haaim.web.authority.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.Role;
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "authority")
@IdClass(AuthorityEntityKey.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuthorityEntity extends CommonEntity implements Serializable {
	@Id
	@Column(name = "menu_code")
	private String menuCode;
	
	@Id
	@Column(name = "user_type")
	private Role userType;
	
	@Column(name = "use_yn")
	private int usage = 0;
	
	@Builder
	public AuthorityEntity(String menuCode, int userType, int usage, String inputId, Date inputDate, String updateId, Date updateDate) {
		super(inputId, inputDate, updateId, updateDate);
		
		validate(menuCode, userType, usage);
		
		this.menuCode = menuCode;
		this.userType = Role.getRole(userType);
		this.usage = usage;
	}
	
	private void validate(String menuCode, int userType, int usage) {
		
	}
}
