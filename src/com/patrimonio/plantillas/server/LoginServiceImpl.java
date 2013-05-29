package com.patrimonio.plantillas.server;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.patrimonio.plantillas.client.LoginService;
import com.patrimonio.plantillas.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	public String loginServer(String name, String pass) throws IllegalArgumentException {
//		// Verify that the name is valid. 
		if (!FieldVerifier.isValidName(name)) {
			// If the name is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}
//
//		String serverInfo = getServletContext().getServerInfo();
//		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
//
//		// Escape data from the client to avoid cross-site script vulnerabilities.
//		name = escapeHtml(name);
//		userAgent = escapeHtml(userAgent);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				         System.out.println("El valor de authentication es: " + authentication);
        if (authentication==null){
        	return "Ha habido un error!";
        }
        else{
		//AQUI FALTA VALIDAR QUE EL NOMBRE Y EL PASS SEAN IGUALES A LOS GUARDADOS...REPASAR!
        	
        	
        	
		return "Hello, " + (String) authentication.getPrincipal() + "!<br><br>"
				+ ".<br><br>And your password is:<br>" + pass;
				        }
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
