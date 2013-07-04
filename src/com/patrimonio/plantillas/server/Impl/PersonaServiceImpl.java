package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.PersonasDao;
import com.patrimonio.plantillas.shared.clases.Personas;
import com.patrimonio.plantillas.client.services.PersonaService;

public class PersonaServiceImpl extends RemoteServiceServlet implements PersonaService{
	
	public PersonasDao personaDao = new PersonasDao();

	@Override
	public PagingLoadResult<Personas> findAll(PagingLoadConfig config){
		return personaDao.getPersonas(config);
	}
	
	@Override
	public Personas findPersona(long idPersona) {
		
		return personaDao.findById(idPersona);
	}

	@Override
	public void savePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Personas persona = personaDao.findById(idPersona);
		if(persona==null){
			persona = new Personas(idPersona, estado, perfil, descripcion);
			personaDao.savePersona(persona);
		}
	}

	@Override
	public void updatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Personas persona = personaDao.findById(idPersona);
		if(persona!=null){
			persona.setId_estado(estado);
			persona.setId_perfil(perfil);
			persona.setDescripcion(descripcion);
			personaDao.updatePersona(persona);
		}
		
	}

	@Override
	public void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		Personas persona = new Personas(idPersona, estado, perfil, descripcion);
		personaDao.updatePersona(persona);
		
	}

	@Override
	public void deletePersona(long idPersona) throws Exception {
		Personas persona = personaDao.findById(idPersona);
		if(persona!=null){
			personaDao.removePersona(persona);
		}
		
	}

}
