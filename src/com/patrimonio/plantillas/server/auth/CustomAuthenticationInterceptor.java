package com.patrimonio.plantillas.server.auth;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomAuthenticationInterceptor implements MethodInterceptor {

        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                
                System.out.println("CustomAuthenticationInterceptor Method name : " + methodInvocation.getMethod().getName());
                System.out.println("CustomAuthenticationInterceptor Method arguments : " + Arrays.toString(methodInvocation.getArguments()));
                
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName(); //get logged in username
            System.out.println("user logged: " + name);
 
                try {
                        Object result = methodInvocation.proceed();
                        return result;
                } catch (IllegalArgumentException e) {
                        throw e;
                }
        }

}
