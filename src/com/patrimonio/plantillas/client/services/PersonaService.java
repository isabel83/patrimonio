package com.patrimonio.plantillas.client.services;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Personas;

@RemoteServiceRelativePath("persona")
public interface PersonaService extends RemoteService{
	
	public PagingLoadResult<Personas> findAll(PagingLoadConfig config);
	public Personas findPersona (long idPersona);
	public void savePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void updatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void deletePersona(long idPersona) throws Exception;
}
