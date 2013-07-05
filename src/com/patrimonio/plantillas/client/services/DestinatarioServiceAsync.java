package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public interface DestinatarioServiceAsync {

	void findDestinatario(long idDestinatario, AsyncCallback<Destinatarios> callback);

	void saveDestinatario(Destinatarios destinatario, AsyncCallback<Void> callback);

	void updateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void deleteDestinatario(long idDestinatario, AsyncCallback<Void> callback);

	void findAllForList(AsyncCallback<List<Destinatarios>> asyncCallback);

	
}
