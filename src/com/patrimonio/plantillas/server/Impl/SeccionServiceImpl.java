package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.SeccionDao;
import com.patrimonio.plantillas.shared.DTOs.SeccionDTO;
import com.patrimonio.plantillas.shared.services.SeccionService;

public class SeccionServiceImpl implements SeccionService{
	
	public SeccionDao seccionDAO;

	@Override
	public SeccionDTO findSeccion(long idSeccion) {
		
		return seccionDAO.findById(idSeccion);
	}

	@Override
	public void saveSeccion(long idSeccion, String descripcion, int estado)	throws Exception {
		SeccionDTO seccionDto = seccionDAO.findById(idSeccion);
		if(seccionDto==null){
			seccionDto = new SeccionDTO(idSeccion, descripcion, estado);
			seccionDAO.persist(seccionDto);
		}
		
	}

	@Override
	public void updateSeccion(long idSeccion, String descripcion, int estado) throws Exception {
		SeccionDTO seccionDto = seccionDAO.findById(idSeccion);
		if(seccionDto!=null){
			seccionDto.setDescripcion(descripcion);
			seccionDto.setId_estado(estado);
		}
		
	}

	@Override
	public void saveOrUpdateSeccion(long idSeccion, String descripcion,	int estado) throws Exception {
		SeccionDTO seccionDto = new SeccionDTO(idSeccion,descripcion,estado);
		seccionDAO.merge(seccionDto);
	}

	@Override
	public void deleteSeccion(long idSeccion) throws Exception {
		SeccionDTO seccionDto = seccionDAO.findById(idSeccion);
		if(seccionDto!=null)
			seccionDAO.remove(seccionDto);
	}

}