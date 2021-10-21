package net.haaim.web.api.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.user.entity.CustomUserDetails;
import net.haaim.web.api.user.service.CustomUserDetailService;


/**
 * UserDetailsService를 구현한 UserDetailsServiceImpl과 기본 DaoAuthenticationProvider를 이용한 폼기반 인증도 있지만,
 * 이 클래스처럼 직접 AuthenticationProvider를 구현하여 UserDetailsService를 구현하지 않아도 되는 폼기반 인증도 있다.
 * 
 *
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class CustomUserAuthenticationProvider implements AuthenticationProvider {

	private final CustomUserDetailService userDetailsService;
	private final PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		log.debug("CustomUserAuthenticationProvider.authenticate ::::");
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		
		String userName = token.getName();
		
		log.debug("userName:" + userName);
		
		CustomUserDetails user = null;
		
		if(!StringUtils.isEmpty(userName)) {
			user = userDetailsService.loadUserByUsername(userName);
		}
		
		log.debug("user:" + user);
		
		if(ObjectUtils.isEmpty(user)) {
			throw new UsernameNotFoundException("Invalid username");
		}

		String password = user.getPassword();
		
		log.debug("입력된 패스워드 = "+password + " 토큰 패스워드 = "+token.getCredentials().toString());
//		if(!StringUtils.equals(password, encoder.encode(String.valueOf(token.getCredentials())))) {
		if(!StringUtils.equals(password, String.valueOf(token.getCredentials()))) {
			throw new BadCredentialsException("Invalid password");
		}
		
		return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		log.debug("CustomUserAuthenticationProvider.supports ::::");
		return UsernamePasswordAuthenticationToken
				.class.equals(authentication);
	}

}
