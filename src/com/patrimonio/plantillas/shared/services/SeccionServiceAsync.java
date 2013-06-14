package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.SeccionDTO;

public interface SeccionServiceAsync {

	void findSeccion(long idSeccion, AsyncCallback<SeccionDTO> callback);

	void saveSeccion(long idSeccion, String descripcion, int estado, AsyncCallback<Void> callback);

	void updateSeccion(long idSeccion, String descripcion, int estado, AsyncCallback<Void> callback);

	void saveOrUpdateSeccion(long idSeccion, String descripcion, int estado, AsyncCallback<Void> callback);

	void deleteSeccion(long idSeccion, AsyncCallback<Void> callback);

}
