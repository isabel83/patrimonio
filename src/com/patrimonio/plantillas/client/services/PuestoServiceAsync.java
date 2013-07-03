package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Puestos;

public interface PuestoServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Puestos>> callback);

	void findPuesto(long idPuesto, AsyncCallback<Puestos> callback);

	void savePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void updatePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void deletePuesto(long idPuesto, AsyncCallback<Void> callback);

}
