package net.haaim.web.api.user.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CustomUserDetails implements UserDetails{
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private Integer uType;
	private String uTypeName;
	private String name;
	private Integer studentNo;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	
	@Builder
	public CustomUserDetails(String username, String password, String authority, Integer uType, String uTypeName, String name, Integer studentNo) {
		this.username = username;
		this.password = password;
		authorities.add(new SimpleGrantedAuthority(authority));
		this.uType = uType;
		this.uTypeName = uTypeName;
		this.name = name;
		this.studentNo = studentNo;
	}
   
	public void addAuthorities(String authority) {
		authorities.add(new SimpleGrantedAuthority(authority));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
}
