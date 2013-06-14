package com.patrimonio.plantillas.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface PuestoServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PuestoService
     */
    void findPuesto( long idPuesto, AsyncCallback<com.patrimonio.plantillas.shared.DTOs.PuestoDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PuestoService
     */
    void savePuesto( long idPuesto, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PuestoService
     */
    void updatePuesto( long idPuesto, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PuestoService
     */
    void saveOrUpdatePuesto( long idPuesto, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PuestoService
     */
    void deletePuesto( long idPuesto, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static PuestoServiceAsync instance;

        public static final PuestoServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (PuestoServiceAsync) GWT.create( PuestoService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "PuestoService" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
