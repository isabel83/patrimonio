package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Familia;

public interface FamiliaServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Familia>> callback);

	void findFamilia(long idFamilia, AsyncCallback<Familia> callback);

	void saveFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void deleteFamilia(long idFamilia, AsyncCallback<Void> callback);

	void saveOrUpdateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void updateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

}
