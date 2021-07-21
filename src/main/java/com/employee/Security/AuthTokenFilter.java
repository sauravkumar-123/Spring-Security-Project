package com.employee.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.employee.ServiceImpl.EmployeeDetailsServiceImpl;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private EmployeeDetailsServiceImpl EmployeeDetailsServiceImpl;
	
	@Autowired
	private JwtUtils JwtUtils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
       
		try {
			String jwt=parseJwt(request);
			if(null!=jwt && JwtUtils.validateJwtToken(jwt)) {
				String employeeEmail=JwtUtils.getUserNameFromJwtToken(jwt);
				UserDetails userdetails=EmployeeDetailsServiceImpl.loadUserByUsername(employeeEmail);
				UsernamePasswordAuthenticationToken authentication =new UsernamePasswordAuthenticationToken(
						userdetails,null,userdetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Cannot set user authentication: {}", e);
		}
		
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth=request.getHeader("Authorization");
		
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}
}
