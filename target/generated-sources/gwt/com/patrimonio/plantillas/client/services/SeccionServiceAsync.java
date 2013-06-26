package com.patrimonio.plantillas.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SeccionServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void findAll( com.extjs.gxt.ui.client.data.PagingLoadConfig config, AsyncCallback<com.extjs.gxt.ui.client.data.PagingLoadResult<com.patrimonio.plantillas.shared.clases.Seccion>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void findSeccion( long idSeccion, AsyncCallback<com.patrimonio.plantillas.shared.clases.Seccion> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void saveSeccion( long idSeccion, java.lang.String descripcion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void updateSeccion( long idSeccion, java.lang.String descripcion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void saveOrUpdateSeccion( long idSeccion, java.lang.String descripcion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SeccionService
     */
    void deleteSeccion( long idSeccion, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static SeccionServiceAsync instance;

        public static final SeccionServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (SeccionServiceAsync) GWT.create( SeccionService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
