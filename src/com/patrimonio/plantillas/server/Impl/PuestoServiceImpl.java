package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.PuestoDao;
import com.patrimonio.plantillas.shared.DTOs.PuestoDTO;
import com.patrimonio.plantillas.shared.services.PuestoService;

public class PuestoServiceImpl implements PuestoService{
	
	public PuestoDao puestoDAO;

	@Override
	public PuestoDTO findPuesto(long idPuesto) {
		return puestoDAO.findById(idPuesto);
	}

	@Override
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		PuestoDTO puestoDTO = puestoDAO.findById(idPuesto);
		if(puestoDTO==null){
			puestoDTO = new PuestoDTO(idPuesto,estado,descripcion);
			puestoDAO.persist(puestoDTO);
		}
		
	}

	@Override
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		PuestoDTO puestoDTO = puestoDAO.findById(idPuesto);
		if(puestoDTO!=null){
			puestoDTO.setDescripcion(descripcion);
			puestoDTO.setId_estado(estado);
		}
		
	}

	@Override
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		PuestoDTO puestoDTO = new PuestoDTO(idPuesto,estado,descripcion);
		puestoDAO.merge(puestoDTO);
		
	}

	@Override
	public void deletePuesto(long idPuesto) throws Exception {
		PuestoDTO puestoDTO = puestoDAO.findById(idPuesto);
		if(puestoDTO!=null)
			puestoDAO.remove(puestoDTO);
		
	}

}
