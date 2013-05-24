package com.patrimonio.plantillas.server.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
        
        private static Map<String, String> users = new HashMap<String, String>();
        
        static {
                users.put("admin", "admin");
                users.put("justin", "javacodegeeks");
        }

        /**
         * The authenticate method is implemented and inside that we retrieve the username provided in the login form 
         * (via the getPrincipal method) as well as the accompanying password (via the getCredentials method). 
         * First, we check if the specific username exists and if not, a UsernameNotFoundException is thrown. 
         * Similarly, if the username exists but the password is incorrect, a BadCredentialsException is thrown. 
         * Note that both theses exceptions extend the parent AuthenticationException class.
         * 
         * Through form login.html, springsecurity redirect to this method (authenticate) using "j_spring_security_check" servlet (action="<c:url value='j_spring_security_check' />") 
         */
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                
                System.out.println("CustomAuthenticationProvider => authenticate() ");
                
                String username = (String) authentication.getPrincipal();
                String password = (String)authentication.getCredentials();
                
                /*
                 * Go to BD to check if this user and pass exists.
                 */
                if (users.get(username)==null)
                        throw new UsernameNotFoundException("User not found");
                
                String storedPass = users.get(username);
                
                if (!storedPass.equals(password))
                        throw new BadCredentialsException("Invalid password");
                
                /* 
                 * If both the username and the password are correct, we are in place to authenticate the user. 
                 * In order to do so, we have to return a concrete instance of the Authentication interface. 
                 * In that, we have to encapsulate the already known user information (credentials etc.) as well as the roles (authorities) 
                 * that the user has. 
                 * Note that the assigned role (ROLE_USER) matches the one declared in the applicationContext-security.xml file.              
                 * 
                 * Read more: http://www.javacodegeeks.com/2010/12/securing-gwt-apps-with-spring-security.html#ixzz1pZXiobcO
                 */
                Authentication customAuthentication = new CustomUserAuthentication("ROLE_USER", authentication);
                
                /*
                 * In addition, the setAuthenticated method has to be invoked (with true as argument) in order to indicate to the rest 
                 * of the authentication chain that the specific user was successfully authenticated by our module
                 */
                customAuthentication.setAuthenticated(true);
                
                return customAuthentication;
                
        }

        /**
         * The supports method defines the kind of authentication that this provider provides. 
         * In our case, the UsernamePasswordAuthenticationToken is the one we wish to handle. That implementation is designed for 
         * simple presentation of a username and password.
         */
        public boolean supports(Class<? extends Object> authentication) {
                return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
        }

}