package com.patrimonio.plantillas.client;

import com.patrimonio.plantillas.shared.Customer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomerServiceAsync {
        
        public void helloWorld(String name, AsyncCallback<String> callback);

        public void saveCustomer(String name, String surname,String jobDescription, AsyncCallback<Customer> callback);

}
