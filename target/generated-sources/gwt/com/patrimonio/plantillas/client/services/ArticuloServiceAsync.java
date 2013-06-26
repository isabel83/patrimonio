package com.patrimonio.plantillas.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface ArticuloServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void findArticulo( long idArticulo, AsyncCallback<com.patrimonio.plantillas.shared.clases.Articulo> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void saveArticulo( long idArticulo, int seccion, int familia, int subFamilia, int codigo, java.lang.String nombre, java.lang.String marca, int numMin, int numIdeal, java.lang.String observacion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void updateArticulo( long idArticulo, int seccion, int familia, int subFamilia, int codigo, java.lang.String nombre, java.lang.String marca, int numMin, int numIdeal, java.lang.String observacion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void saveOrUpdateArticulo( long idArticulo, int seccion, int familia, int subFamilia, int codigo, java.lang.String nombre, java.lang.String marca, int numMin, int numIdeal, java.lang.String observacion, int estado, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void deleteArticulo( long idArticulo, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.client.services.ArticuloService
     */
    void loadArticulosPro( int idProveedor, AsyncCallback<java.util.List<com.patrimonio.plantillas.shared.clases.Articulo>> callback );


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
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
