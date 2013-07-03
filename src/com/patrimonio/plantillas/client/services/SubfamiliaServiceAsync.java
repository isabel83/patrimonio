package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Proveedores;
import com.patrimonio.plantillas.shared.clases.Subfamilias;

public interface SubfamiliaServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Subfamilias>> callback);
	
	void findSubfamilia(long idSubfamilia, AsyncCallback<Subfamilias> callback);

	void saveSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void updateSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void deleteSubfamilia(long idSubfamilia, AsyncCallback<Void> callback);

	

}
