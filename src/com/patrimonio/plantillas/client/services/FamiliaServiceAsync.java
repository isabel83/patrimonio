package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Familias;

public interface FamiliaServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Familias>> callback);

	void findFamilia(long idFamilia, AsyncCallback<Familias> callback);

	void saveFamilia(Familias familia, AsyncCallback<Void> callback);

	void deleteFamilia(long idFamilia, AsyncCallback<Void> callback);

	void saveOrUpdateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void updateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void findAllForList(AsyncCallback<List<Familias>> asyncCallback);

}
