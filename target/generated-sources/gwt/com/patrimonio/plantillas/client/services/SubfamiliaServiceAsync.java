package com.patrimonio.plantillas.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SubfamiliaServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
     */
    void findAll( com.extjs.gxt.ui.client.data.PagingLoadConfig config, AsyncCallback<com.extjs.gxt.ui.client.data.PagingLoadResult<com.patrimonio.plantillas.shared.clases.Subfamilia>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
     */
    void findSubfamilia( long idSubfamilia, AsyncCallback<com.patrimonio.plantillas.shared.clases.Subfamilia> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
     */
    void saveSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
     */
    void updateSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
     */
    void saveOrUpdateSubfamilia( long idSubfamilia, int familia, int estado, java.lang.String descripcion, java.lang.String codigo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.SubfamiliaService
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
