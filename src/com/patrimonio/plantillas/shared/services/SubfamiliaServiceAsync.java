package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.SubfamiliaDTO;

public interface SubfamiliaServiceAsync {
	
	void findSubfamilia(long idSubfamilia, AsyncCallback<SubfamiliaDTO> callback);

	void saveSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void updateSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void deleteSubfamilia(long idSubfamilia, AsyncCallback<Void> callback);

	

}
