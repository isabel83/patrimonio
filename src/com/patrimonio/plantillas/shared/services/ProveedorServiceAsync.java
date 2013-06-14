package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.ProveedorDTO;

public interface ProveedorServiceAsync {

	void findProveedor(long idProveedor, AsyncCallback<ProveedorDTO> callback);

	void saveProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

	void deleteProveedor(long idProveedor, AsyncCallback<Void> callback);

	void saveOrUpdateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

	void updateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado, AsyncCallback<Void> callback);

}
