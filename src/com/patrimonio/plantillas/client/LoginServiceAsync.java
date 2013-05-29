package com.patrimonio.plantillas.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>LoginService</code>.
 */
public interface LoginServiceAsync {
	void loginServer(String name, String pass, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
