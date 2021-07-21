package com.employee.Security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

public class AuthEntryPoint implements AuthenticationEntryPoint {
	
	@Autowired
	UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			             AuthenticationException authException) throws IOException, ServletException {
		
		logger.error("Unauthorized error: {}",authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Wrong Username or Password");
	}

}
