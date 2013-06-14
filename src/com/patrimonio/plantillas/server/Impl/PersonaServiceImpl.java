package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.PersonaDao;
import com.patrimonio.plantillas.shared.DTOs.PersonaDTO;
import com.patrimonio.plantillas.shared.services.PersonaService;

public class PersonaServiceImpl implements PersonaService{
	
	public PersonaDao personaDao;

	@Override
	public PersonaDTO findPersona(long idPersona) {
		
		return personaDao.findById(idPersona);
	}

	@Override
	public void savePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		PersonaDTO personaDto = personaDao.findById(idPersona);
		if(personaDto==null){
			personaDto = new PersonaDTO(idPersona, estado, perfil, descripcion);
			personaDao.persist(personaDto);
		}
	}

	@Override
	public void updatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		PersonaDTO personaDto = personaDao.findById(idPersona);
		if(personaDto!=null){
			personaDto.setId_estado(estado);
			personaDto.setId_perfil(perfil);
			personaDto.setDescripcion(descripcion);
		}
		
	}

	@Override
	public void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion) throws Exception {
		PersonaDTO personaDto = new PersonaDTO(idPersona, estado, perfil, descripcion);
		personaDao.merge(personaDto);
		
	}

	@Override
	public void deletePersona(long idPersona) throws Exception {
		PersonaDTO personaDto = personaDao.findById(idPersona);
		if(personaDto!=null){
			personaDao.remove(personaDto);
		}
		
	}

}
