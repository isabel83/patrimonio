package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.DTOs.PersonaDTO;

@RemoteServiceRelativePath("persona")
public interface PersonaService extends RemoteService{

	public PersonaDTO findPersona (long idPersona);
	public void savePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void updatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception;
	public void deletePersona(long idPersona) throws Exception;
}
