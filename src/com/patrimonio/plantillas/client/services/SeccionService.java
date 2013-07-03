package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Secciones;

@RemoteServiceRelativePath("seccion")
public interface SeccionService extends RemoteService{

	public PagingLoadResult<Secciones> findAll(PagingLoadConfig config);
	public Secciones findSeccion (long idSeccion);
	public void saveSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void updateSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void saveOrUpdateSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void deleteSeccion(long idSeccion) throws Exception;
	
}
