package com.patrimonio.plantillas.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface ArticuloServiceAsync
{

    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ArticuloServiceAsync instance;

        public static final ArticuloServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ArticuloServiceAsync) GWT.create( ArticuloService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "ArticuloService" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
