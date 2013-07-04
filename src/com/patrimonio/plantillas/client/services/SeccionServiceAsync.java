package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Secciones;

public interface SeccionServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Secciones>> callback);

	void findSeccion(long idSeccion, AsyncCallback<Secciones> callback);

	void saveSeccion(Secciones seccion, AsyncCallback<Void> callback);

	void updateSeccion(long idSeccion, String descripcion, int estado, AsyncCallback<Void> callback);

	void saveOrUpdateSeccion(long idSeccion, String descripcion, int estado, AsyncCallback<Void> callback);

	void deleteSeccion(long idSeccion, AsyncCallback<Void> callback);

	void findAllForList(AsyncCallback<List<Secciones>> asyncCallback);

}
