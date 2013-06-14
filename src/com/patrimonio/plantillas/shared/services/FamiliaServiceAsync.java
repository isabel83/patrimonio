package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.FamiliaDTO;

public interface FamiliaServiceAsync {

	void findFamilia(long idFamilia, AsyncCallback<FamiliaDTO> callback);

	void saveFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void deleteFamilia(long idFamilia, AsyncCallback<Void> callback);

	void saveOrUpdateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

	void updateFamilia(long idFamilia, int seccion, int estado,
			String descripcion, String codigo, AsyncCallback<Void> callback);

}
