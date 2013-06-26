package com.patrimonio.plantillas.server.Impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.DestinatarioDao;
import com.patrimonio.plantillas.shared.clases.Destinatario;
import com.patrimonio.plantillas.client.services.DestinatarioService;

public class DestinatarioServiceImpl extends RemoteServiceServlet implements DestinatarioService{
	
	public DestinatarioDao destinatarioDAO;

	@Override
	public Destinatario findDestinatario(long idDestinatario) {
		
		return destinatarioDAO.findById(idDestinatario);
	}

	@Override
	public void saveDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		Destinatario destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario==null){
			destinatario = new Destinatario(idDestinatario,estado,descripcion);
			destinatarioDAO.saveDestinatario(destinatario);
		}
		
	}

	@Override
	public void updateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		Destinatario destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario!=null){
			destinatario.setDescripcion(descripcion);
			destinatario.setId_estado(estado);
			destinatarioDAO.updateDestinatario(destinatario);
		}
	}

	@Override
	public void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		Destinatario destinatario = new Destinatario(idDestinatario,estado,descripcion);
		destinatarioDAO.updateDestinatario(destinatario);
	}

	@Override
	public void deleteDestinatario(long idDestinatario) throws Exception {
		Destinatario destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario!=null)
			destinatarioDAO.removeDestinatario(destinatario);
	}

}
