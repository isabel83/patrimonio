package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.DestinatarioDao;
import com.patrimonio.plantillas.shared.DTOs.DestinatarioDTO;
import com.patrimonio.plantillas.shared.services.DestinatarioService;

public class DestinatarioServiceImpl implements DestinatarioService{
	
	public DestinatarioDao destinatarioDAO;

	@Override
	public DestinatarioDTO findDestinatario(long idDestinatario) {
		
		return destinatarioDAO.findById(idDestinatario);
	}

	@Override
	public void saveDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		DestinatarioDTO destinatarioDTO = destinatarioDAO.findById(idDestinatario);
		if(destinatarioDTO==null){
			destinatarioDTO = new DestinatarioDTO(idDestinatario,estado,descripcion);
			destinatarioDAO.persist(destinatarioDTO);
		}
		
	}

	@Override
	public void updateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		DestinatarioDTO destinatarioDTO = destinatarioDAO.findById(idDestinatario);
		if(destinatarioDTO!=null){
			destinatarioDTO.setDescripcion(descripcion);
			destinatarioDTO.setId_estado(estado);
		}
	}

	@Override
	public void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		DestinatarioDTO destinatarioDTO = new DestinatarioDTO(idDestinatario,estado,descripcion);
		destinatarioDAO.merge(destinatarioDTO);
	}

	@Override
	public void deleteDestinatario(long idDestinatario) throws Exception {
		DestinatarioDTO destinatarioDTO = destinatarioDAO.findById(idDestinatario);
		if(destinatarioDTO!=null)
			destinatarioDAO.remove(destinatarioDTO);
	}

}
