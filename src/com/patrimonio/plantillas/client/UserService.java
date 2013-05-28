package com.patrimonio.plantillas.client;


import com.patrimonio.plantillas.shared.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/UserService")
public interface UserService extends RemoteService {

        
        public User saveUser(String name, String surname, String jobDescription);



}