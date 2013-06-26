package com.patrimonio.plantillas.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface ProveedorServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void findAll( com.extjs.gxt.ui.client.data.PagingLoadConfig config, AsyncCallback<com.extjs.gxt.ui.client.data.PagingLoadResult<com.patrimonio.plantillas.shared.clases.Proveedor>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void findProveedor( long idProveedor, AsyncCallback<com.patrimonio.plantillas.shared.clases.Proveedor> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void saveProveedor( long id, java.lang.String nif, java.lang.String nombre, java.lang.String actividad, java.lang.String contacto, java.lang.String direccion, java.lang.String poblacion, int cp, java.lang.String provincia, java.lang.String tf1, java.lang.String tf2, int mvl, java.lang.String fax, java.lang.String mail, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void updateProveedor( long id, java.lang.String nif, java.lang.String nombre, java.lang.String actividad, java.lang.String contacto, java.lang.String direccion, java.lang.String poblacion, int cp, java.lang.String provincia, java.lang.String tf1, java.lang.String tf2, int mvl, java.lang.String fax, java.lang.String mail, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void saveOrUpdateProveedor( long id, java.lang.String nif, java.lang.String nombre, java.lang.String actividad, java.lang.String contacto, java.lang.String direccion, java.lang.String poblacion, int cp, java.lang.String provincia, java.lang.String tf1, java.lang.String tf2, int mvl, java.lang.String fax, java.lang.String mail, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void deleteProveedor( long idProveedor, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ProveedorService
     */
    void findAllForList( AsyncCallback<java.util.List<com.patrimonio.plantillas.client.DTOs.ProveedorDTO>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ProveedorServiceAsync instance;

        public static final ProveedorServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ProveedorServiceAsync) GWT.create( ProveedorService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
