package net.haaim.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.debug("CustomAccessDeniedHandler.handle");
        this.makeExceptionResponse(request, response, accessDeniedException);
    }
 
    public void makeExceptionResponse(HttpServletRequest request, HttpServletResponse response,
            Exception exception) throws IOException {
        log.debug("CustomAccessDeniedHandler.makeExceptionResponse :::: {}",exception.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
    }
    
}


