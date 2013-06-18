package com.patrimonio.plantillas.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SubfamiliaServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.SubfamiliaService
     */
    void findSubfamilia( long idSubfamilia, AsyncCallback<com.patrimonio.plantillas.shared.DTOs.SubfamiliaDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.SubfamiliaService
     */
    void saveSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.SubfamiliaService
     */
    void updateSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.SubfamiliaService
     */
    void saveOrUpdateSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.SubfamiliaService
     */
    void deleteSubfamilia( long idSubfamilia, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static SubfamiliaServiceAsync instance;

        public static final SubfamiliaServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (SubfamiliaServiceAsync) GWT.create( SubfamiliaService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
