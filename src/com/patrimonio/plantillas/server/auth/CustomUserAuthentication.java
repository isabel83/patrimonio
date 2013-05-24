package com.patrimonio.plantillas.server.auth;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class CustomUserAuthentication implements Authentication {
        
        private static final long serialVersionUID = -3091441742758356129L;
        
        private boolean authenticated;
        
        private GrantedAuthority grantedAuthority;
        private Authentication authentication;
        
        /**
         * In the constructor, we pass the user's role and the original Authentication object. 
         * In the implemented methods, the most important one is the getAuthorities, which returns the authorities (roles) that the principal 
         * has been granted. That information is provided inside a collection of GrantedAuthority objects.
         * @param role
         * @param authentication
         */
        public CustomUserAuthentication(String role, Authentication authentication) {
                this.grantedAuthority = new GrantedAuthorityImpl(role);
                this.authentication = authentication;
        }

        public Collection<GrantedAuthority> getAuthorities() {
                System.out.println("CustomUserAuthentication => getAuthorities() ");
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(grantedAuthority);
                return authorities;
        }

        public Object getCredentials() {
                System.out.println("CustomUserAuthentication => getCredentials() ");
                return authentication.getCredentials();
        }

        public Object getDetails() {
                System.out.println("CustomUserAuthentication => getDetails() ");
                return authentication.getDetails();
        }

        public Object getPrincipal() {
                System.out.println("CustomUserAuthentication => getPrincipal() ");
                return authentication.getPrincipal();
        }

        public boolean isAuthenticated() {
                System.out.println("CustomUserAuthentication => isAuthenticated() ");
                return authenticated;
        }

        public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
                System.out.println("CustomUserAuthentication => setAuthenticated() ");
                this.authenticated = authenticated;
        }

        public String getName() {
                System.out.println("CustomUserAuthentication => getName() ");
                return authentication.getName();
                //return this.getClass().getSimpleName();
        }

}