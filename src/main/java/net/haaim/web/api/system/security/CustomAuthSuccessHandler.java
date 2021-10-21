package net.haaim.web.api.system.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.haaim.web.api.common.Role;
import net.haaim.web.api.user.entity.CustomUserDetails;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String redirectUrl = "";
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains(Role.STUDENT.getRemark())) {
			redirectUrl = "/student/studentMain.html";
		} else {
			redirectUrl = "/admin/adminMain.html";
		}
		
		//로그인 후 세션 정보를 저장한다.
		CustomUserDetails details = (CustomUserDetails)authentication.getPrincipal();
		
		log.debug("details : " + details);
//		request.getSession().setAttribute(details.getUsername(), details);
//		request.getSession().setMaxInactiveInterval(30);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		
		
		redirectStratgy.sendRedirect(request, response, redirectUrl);
	}

}
