package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.SubfamiliaDao;
import com.patrimonio.plantillas.shared.DTOs.SubfamiliaDTO;
import com.patrimonio.plantillas.shared.services.SubfamiliaService;

public class SubfamiliaServiceImpl implements SubfamiliaService{
	public SubfamiliaDao subfamiliaDAO;

	@Override
	public SubfamiliaDTO findSubfamilia(long idSubfamilia) {
		
		return subfamiliaDAO.findById(idSubfamilia);
	}

	@Override
	public void saveSubfamilia(long idSubfamilia, int familia, int estado,String descripcion, String codigo) throws Exception {
		
		SubfamiliaDTO subfamiliaDTO = subfamiliaDAO.findById(idSubfamilia);
		if(subfamiliaDTO==null){
			subfamiliaDTO = new SubfamiliaDTO(idSubfamilia,familia,estado,descripcion,codigo);
			subfamiliaDAO.persist(subfamiliaDTO);
		}
		
	}

	@Override
	public void updateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception {
		SubfamiliaDTO subfamiliaDTO = subfamiliaDAO.findById(idSubfamilia);
		if(subfamiliaDTO!=null){
			subfamiliaDTO.setId_familia(familia);
			subfamiliaDTO.setId_estado(estado);
			subfamiliaDTO.setDescripcion(descripcion);
			subfamiliaDTO.setCodigo(codigo);
		}
	}

	@Override
	public void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception {
		
		SubfamiliaDTO subfamiliaDTO = new SubfamiliaDTO(idSubfamilia,familia,estado,descripcion,codigo);
		subfamiliaDAO.merge(subfamiliaDTO);
		
	}

	@Override
	public void deleteSubfamilia(long idSubfamilia) throws Exception {
		SubfamiliaDTO subfamiliaDTO= subfamiliaDAO.findById(idSubfamilia);
		if(subfamiliaDTO!=null){
			subfamiliaDAO.remove(subfamiliaDTO);
		}
	}
}
