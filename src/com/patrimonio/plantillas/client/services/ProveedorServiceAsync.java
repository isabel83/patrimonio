package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.DTOs.ProveedorDTO;
import com.patrimonio.plantillas.shared.clases.Proveedor;

public interface ProveedorServiceAsync {
	
	void findAll(PagingLoadConfig config, AsyncCallback<PagingLoadResult<Proveedor>> callback);

	void findProveedor(long idProveedor, AsyncCallback<Proveedor> callback);

	void saveProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

	void deleteProveedor(long idProveedor, AsyncCallback<Void> callback);

	void saveOrUpdateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

	void updateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

	void findAllForList(AsyncCallback<List<ProveedorDTO>> asyncCallback); 

	

}
