package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.client.DTOs.ProveedoresDTO;
import com.patrimonio.plantillas.shared.clases.Proveedores;

@RemoteServiceRelativePath("proveedor")
public interface ProveedorService extends RemoteService{
	public PagingLoadResult<Proveedores> findAll(PagingLoadConfig config);
	public Proveedores findProveedor (long idProveedor);
	public void updateProveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado) throws Exception;
	public void saveOrUpdateProveedor(String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado) throws Exception;
	public void deleteProveedor(long idProveedor) throws Exception;
	public List<Proveedores> findAllForList()throws Exception;
	public void saveProveedor(Proveedores proveedor) throws Exception;
}
