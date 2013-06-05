package com.patrimonio.plantillas.server.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	 //protected static Logger logger = Logger.getLogger("security");
	  
	 public void commence(HttpServletRequest request, HttpServletResponse response,
	   AuthenticationException exception) throws IOException, ServletException {
	 
	  // logger.debug("Authentication required");
	    
	    HttpServletResponse httpResponse = (HttpServletResponse) response;
	         httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication required");
	 }
    
    
}