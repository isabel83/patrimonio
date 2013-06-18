package com.patrimonio.plantillas.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.DTOs.ProveedorDTO;

@RemoteServiceRelativePath("proveedor")
public interface ProveedorService extends RemoteService{
	public List<ProveedorDTO> findAll();
	public ProveedorDTO findProveedor (long idProveedor);
	public void saveProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado) throws Exception;
	public void updateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado) throws Exception;
	public void saveOrUpdateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado) throws Exception;
	public void deleteProveedor(long idProveedor) throws Exception;
}
