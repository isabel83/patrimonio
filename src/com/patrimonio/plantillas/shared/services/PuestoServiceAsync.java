package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.PuestoDTO;

public interface PuestoServiceAsync {

	void findPuesto(long idPuesto, AsyncCallback<PuestoDTO> callback);

	void savePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void updatePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion, AsyncCallback<Void> callback);

	void deletePuesto(long idPuesto, AsyncCallback<Void> callback);

}
