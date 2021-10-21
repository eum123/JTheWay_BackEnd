package net.haaim.web.api.user.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomUserDetails implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	@Builder
	public CustomUserDetails(String username, String password, String authority) {
		this.username = username;
		this.password = password;
		authorities.add(new SimpleGrantedAuthority(authority));
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
