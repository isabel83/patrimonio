package com.patrimonio.plantillas.server.Impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.patrimonio.plantillas.client.LoginService;
import com.patrimonio.plantillas.shared.FieldVerifier;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
 
/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	public String loginServer(String name, String pass) throws IllegalArgumentException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				        
		System.out.println("El valor de authentication es: " + authentication);
        
		
		if (authentication==null){
        	return "Ha habido un error!";
        }
        else{
		//AQUI FALTA VALIDAR QUE EL NOMBRE Y EL PASS SEAN IGUALES A LOS GUARDADOS...REPASAR!
        	return (String) authentication.getPrincipal();
		}
	}
 
}
