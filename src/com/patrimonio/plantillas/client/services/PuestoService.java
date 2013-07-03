package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Puestos;

@RemoteServiceRelativePath("puesto")
public interface PuestoService extends RemoteService{

	public PagingLoadResult<Puestos> findAll(PagingLoadConfig config);
	public Puestos findPuesto (long idPuesto);
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void deletePuesto(long idPuesto) throws Exception;
}
