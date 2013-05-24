package com.patrimonio.plantillas.client;


import com.patrimonio.plantillas.shared.Customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("services/customerService")
public interface CustomerService extends RemoteService {

        public String helloWorld(String name);
        
        public Customer saveCustomer(String name, String surname, String jobDescription);



}