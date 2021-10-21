package net.haaim.web.api.system.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
	
	private final String DEFAULT_FAILURE_URL;
	
	private final int NOT_MATCHED_PASSWORD = 1;
	private final int NOT_FOUND_USERNAME = 2;
	private final int DISABLED_ACCOUNT = 3;
	private final int CREDENTIALS_EXPIRED = 4;
	private final int UNKNOWN_ERROR = 9;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		int errorType = UNKNOWN_ERROR;
		
		if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
			errorType = NOT_MATCHED_PASSWORD;
		}
		
		if(exception instanceof UsernameNotFoundException) {
			errorType = NOT_FOUND_USERNAME;
		}
		
		if(exception instanceof DisabledException) {
			errorType = DISABLED_ACCOUNT;
		}
		
		if(exception instanceof CredentialsExpiredException) {
			errorType = CREDENTIALS_EXPIRED;
		}
		
		log.debug("auth fail : " + errorType);
		
		request.getRequestDispatcher(DEFAULT_FAILURE_URL + "&error_type=" + errorType).forward(request, response);
	}

}
