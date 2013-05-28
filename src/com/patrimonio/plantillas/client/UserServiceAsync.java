package com.patrimonio.plantillas.client;

import com.patrimonio.plantillas.shared.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {
        

        public void saveUser(String name, String surname,String jobDescription, AsyncCallback<User> callback);

}
