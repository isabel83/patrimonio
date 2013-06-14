package com.patrimonio.plantillas.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface PersonaServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PersonaService
     */
    void findPersona( long idPersona, AsyncCallback<com.patrimonio.plantillas.shared.DTOs.PersonaDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PersonaService
     */
    void savePersona( long idPersona, int estado, int perfil, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PersonaService
     */
    void updatePersona( long idPersona, int estado, int perfil, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PersonaService
     */
    void saveOrUpdatePersona( long idPersona, int estado, int perfil, java.lang.String descripcion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.patrimonio.plantillas.shared.services.PersonaService
     */
    void deletePersona( long idPersona, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static PersonaServiceAsync instance;

        public static final PersonaServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (PersonaServiceAsync) GWT.create( PersonaService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "PersonaService" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
