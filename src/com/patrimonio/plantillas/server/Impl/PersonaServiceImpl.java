package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.PersonaDao;
import com.patrimonio.plantillas.shared.clases.Persona;
import com.patrimonio.plantillas.client.services.PersonaService;

public class PersonaServiceImpl extends RemoteServiceServlet implements PersonaService{
	
	public PersonaDao personaDao;

	@Override
	public PagingLoadResult<Persona> findAll(PagingLoadConfig config){
		return personaDao.getPersonas(config);
	}
	
	@Override
	public Persona findPersona(long idPersona) {
		
		return personaDao.findById(idPersona);
	}

	@Override
	public void savePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Persona persona = personaDao.findById(idPersona);
		if(persona==null){
			persona = new Persona(idPersona, estado, perfil, descripcion);
			personaDao.savePersona(persona);
		}
	}

	@Override
	public void updatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Persona persona = personaDao.findById(idPersona);
		if(persona!=null){
			persona.setId_estado(estado);
			persona.setId_perfil(perfil);
			persona.setDescripcion(descripcion);
			personaDao.updatePersona(persona);
		}
		
	}

	@Override
	public void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Persona persona = new Persona(idPersona, estado, perfil, descripcion);
		personaDao.updatePersona(persona);
		
	}

	@Override
	public void deletePersona(long idPersona) throws Exception {
		Persona persona = personaDao.findById(idPersona);
		if(persona!=null){
			personaDao.removePersona(persona);
		}
		
	}

}
