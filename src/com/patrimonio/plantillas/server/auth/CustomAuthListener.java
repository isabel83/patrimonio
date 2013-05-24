package com.patrimonio.plantillas.server.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthListener implements ApplicationListener<ApplicationEvent> {

        private static final Log logger = LogFactory.getLog(CustomAuthListener.class);
        
        public void onApplicationEvent(ApplicationEvent  event) {


                if (event instanceof AuthenticationSuccessEvent) {
                        AuthenticationSuccessEvent authenticationEvent = (AuthenticationSuccessEvent)event;
                        CustomUserAuthentication authentication2 = (CustomUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
                        System.out.println("user name: " + ((CustomUserAuthentication)authenticationEvent.getAuthentication()).getName());
                        System.out.println("SecurityContextHolder context : " + authentication2);

                } else if (event instanceof AuthorizationFailureEvent) {
                        AuthorizationFailureEvent authorizationEvent = (AuthorizationFailureEvent)event;
                        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                        Authentication authentication2 = authorizationEvent.getAuthentication();
                        System.out.println("user name: " + authentication2.getName());
                        System.out.println("SecurityContextHolder context : " + authentication);
                        
                } else if (event instanceof HttpSessionDestroyedEvent) {
                        HttpSessionDestroyedEvent destroyEvent = (HttpSessionDestroyedEvent)event;
                        CustomUserAuthentication authentication2 = (CustomUserAuthentication) SecurityContextHolder.getContext().getAuthentication();
                        SecurityContext securityContext = destroyEvent.getSecurityContext();
                        System.out.println("user name: session vencida");
                        System.out.println("SecurityContextHolder context : " + authentication2);
                }

        }

}        

