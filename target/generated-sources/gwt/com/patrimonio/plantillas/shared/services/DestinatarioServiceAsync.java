package com.patrimonio.plantillas.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface DestinatarioServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.DestinatarioService
     */
    void findDestinatario( long idDestinatario, AsyncCallback<com.patrimonio.plantillas.shared.DTOs.DestinatarioDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.DestinatarioService
     */
    void saveDestinatario( long idDestinatario, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.DestinatarioService
     */
    void updateDestinatario( long idDestinatario, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.DestinatarioService
     */
    void saveOrUpdateDestinatario( long idDestinatario, int estado, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.DestinatarioService
     */
    void deleteDestinatario( long idDestinatario, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static DestinatarioServiceAsync instance;

        public static final DestinatarioServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (DestinatarioServiceAsync) GWT.create( DestinatarioService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
