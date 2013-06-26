package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Puesto;

@RemoteServiceRelativePath("puesto")
public interface PuestoService extends RemoteService{

	public PagingLoadResult<Puesto> findAll(PagingLoadConfig config);
	public Puesto findPuesto (long idPuesto);
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void deletePuesto(long idPuesto) throws Exception;
}
