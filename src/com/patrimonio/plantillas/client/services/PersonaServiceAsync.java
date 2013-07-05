package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Personas;

public interface PersonaServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Personas>> callback);
	
	void findAllForList(AsyncCallback<List<Personas>> callback);

	void findPersona(long idPersona, AsyncCallback<Personas> callback);

	void deletePersona(long idPersona, AsyncCallback<Void> callback);

	void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion, AsyncCallback<Void> callback);

	void updatePersona(long idPersona, int estado, int perfil, String descripcion, AsyncCallback<Void> callback);

	void savePersona(Personas persona, AsyncCallback<Void> asyncCallback);

}
