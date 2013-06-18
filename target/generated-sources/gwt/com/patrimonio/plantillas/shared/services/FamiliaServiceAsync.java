package com.patrimonio.plantillas.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface FamiliaServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.FamiliaService
     */
    void findFamilia( long idFamilia, AsyncCallback<com.patrimonio.plantillas.shared.DTOs.FamiliaDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.FamiliaService
     */
    void saveFamilia( long idFamilia, int seccion, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.FamiliaService
     */
    void updateFamilia( long idFamilia, int seccion, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.FamiliaService
     */
    void saveOrUpdateFamilia( long idFamilia, int seccion, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.FamiliaService
     */
    void deleteFamilia( long idFamilia, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static FamiliaServiceAsync instance;

        public static final FamiliaServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (FamiliaServiceAsync) GWT.create( FamiliaService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
