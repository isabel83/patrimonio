package com.patrimonio.plantillas.server.Impl;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
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
//		Destinatarios destinatario = new Destinatarios(estado,descripcion);
//		destinatarioDAO.updateDestinatario(destinatario);
	}

	@Override
	public void deleteDestinatario(long idDestinatario) throws Exception {
		Destinatarios destinatario = destinatarioDAO.findById(idDestinatario);
		if(destinatario!=null)
			destinatarioDAO.removeDestinatario(destinatario);
	}

	@Override
	public List<Destinatarios> findAllForList() throws Exception {
		return destinatarioDAO.findAll();
	}

	@Override
	public PagingLoadResult<Destinatarios> getDestinatarios(PagingLoadConfig config) throws Exception {
		return destinatarioDAO.getDestinatarios(config);
	}

}
