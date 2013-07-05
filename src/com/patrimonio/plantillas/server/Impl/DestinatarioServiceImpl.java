package com.patrimonio.plantillas.server.Impl;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.DestinatariosDao;
import com.patrimonio.plantillas.shared.clases.Destinatarios;
import com.patrimonio.plantillas.client.services.DestinatarioService;

public class DestinatarioServiceImpl extends RemoteServiceServlet implements DestinatarioService{
	
	public DestinatariosDao destinatarioDAO = new DestinatariosDao();

	@Override
	public Destinatarios findDestinatario(long idDestinatario) {
		
		return destinatarioDAO.findById(idDestinatario);
	}

	@Override
	public void saveDestinatario(Destinatarios destinatario) throws Exception {
//		Destinatarios destinatario = destinatarioDAO.findById(idDestinatario);
//		if(destinatario==null){
//			destinatario = new Destinatarios(idDestinatario,estado,descripcion);
//			destinatarioDAO.saveDestinatario(destinatario);
//		}
		
		destinatarioDAO.saveDestinatario(destinatario);
	}

	@Override
	public void updateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		Destinatarios destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario!=null){
			destinatario.setDescripcion(descripcion);
			destinatario.setId_estado(estado);
			destinatarioDAO.updateDestinatario(destinatario);
		}
	}

	@Override
	public void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception {
		Destinatarios destinatario = new Destinatarios(idDestinatario,estado,descripcion);
		destinatarioDAO.updateDestinatario(destinatario);
	}

	@Override
	public void deleteDestinatario(long idDestinatario) throws Exception {
		Destinatarios destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario!=null)
			destinatarioDAO.removeDestinatario(destinatario);
	}

	@Override
	public List<Destinatarios> findAllForList() throws Exception {
		// TODO Auto-generated method stub
		return destinatarioDAO.findAll();
	}

}
