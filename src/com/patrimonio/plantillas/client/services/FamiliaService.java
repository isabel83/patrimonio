package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Familias;

@RemoteServiceRelativePath("familia")
public interface FamiliaService extends RemoteService{

	public PagingLoadResult<Familias> findAll(PagingLoadConfig config);
	public Familias findFamilia (long idFamilia);
	public void saveFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void updateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void saveOrUpdateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void deleteFamilia(long idFamilia) throws Exception;
}
