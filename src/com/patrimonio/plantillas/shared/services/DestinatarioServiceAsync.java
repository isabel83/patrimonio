package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.DestinatarioDTO;

public interface DestinatarioServiceAsync {

	void findDestinatario(long idDestinatario, AsyncCallback<DestinatarioDTO> callback);

	void saveDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void updateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void deleteDestinatario(long idDestinatario, AsyncCallback<Void> callback);

	
}
