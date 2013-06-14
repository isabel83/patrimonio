package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.FamiliaDao;
import com.patrimonio.plantillas.shared.DTOs.FamiliaDTO;
import com.patrimonio.plantillas.shared.services.FamiliaService;

public class FamiliaServiceImpl implements FamiliaService{
	
	public FamiliaDao familiaDAO;

	@Override
	public FamiliaDTO findFamilia(long idFamilia) {
		
		return familiaDAO.findById(idFamilia);
	}

	@Override
	public void saveFamilia(long idFamilia, int seccion, int estado,String descripcion, String codigo) throws Exception {
		
		FamiliaDTO familiaDTO = familiaDAO.findById(idFamilia);
		if(familiaDTO==null){
			familiaDTO = new FamiliaDTO(idFamilia,seccion,estado,descripcion,codigo);
			familiaDAO.persist(familiaDTO);
		}
		
	}

	@Override
	public void updateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception {
		FamiliaDTO familiaDTO = familiaDAO.findById(idFamilia);
		if(familiaDTO!=null){
			familiaDTO.setId_seccion(seccion);
			familiaDTO.setId_estado(estado);
			familiaDTO.setDescripcion(descripcion);
			familiaDTO.setCodigo(codigo);
		}
	}

	@Override
	public void saveOrUpdateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception {
		
		FamiliaDTO familiaDTO = new FamiliaDTO(idFamilia,seccion,estado,descripcion,codigo);
		familiaDAO.merge(familiaDTO);
		
	}

	@Override
	public void deleteFamilia(long idFamilia) throws Exception {
		FamiliaDTO familiaDTO = familiaDAO.findById(idFamilia);
		if(familiaDTO!=null){
			familiaDAO.remove(familiaDTO);
		}
	}

}
 