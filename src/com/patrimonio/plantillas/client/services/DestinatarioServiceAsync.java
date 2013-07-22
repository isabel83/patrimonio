package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public interface DestinatarioServiceAsync {

	void findDestinatario(long idDestinatario, AsyncCallback<Destinatarios> callback);

	void saveDestinatario(Destinatarios destinatario, AsyncCallback<Void> callback);

	void updateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion, AsyncCallback<Void> callback);

	void deleteDestinatario(long idDestinatario, AsyncCallback<Void> callback);

	void findAllForList(AsyncCallback<List<Destinatarios>> asyncCallback);

	void getDestinatarios(PagingLoadConfig loadConfig, AsyncCallback<PagingLoadResult<Destinatarios>> callback);

	
}
