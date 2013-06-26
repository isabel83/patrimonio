package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.SeccionDao;
import com.patrimonio.plantillas.shared.clases.Seccion;
import com.patrimonio.plantillas.client.services.SeccionService;

public class SeccionServiceImpl extends RemoteServiceServlet implements SeccionService{
	
	public SeccionDao seccionDAO;

	@Override
	public PagingLoadResult<Seccion> findAll(PagingLoadConfig config) {
		
		return seccionDAO.getSecciones(config);
	}
	
	@Override
	public Seccion findSeccion(long idSeccion) {
		
		return seccionDAO.findById(idSeccion);
	}

	@Override
	public void saveSeccion(long idSeccion, String descripcion, int estado)	throws Exception {
		Seccion seccion = seccionDAO.findById(idSeccion);
		if(seccion==null){
			seccion = new Seccion(idSeccion, descripcion, estado);
			seccionDAO.saveSeccion(seccion);
		}
		
	}

	@Override
	public void updateSeccion(long idSeccion, String descripcion, int estado) throws Exception {
		Seccion seccion = seccionDAO.findById(idSeccion);
		if(seccion!=null){
			seccion.setDescripcion(descripcion);
			seccion.setId_estado(estado);
			seccionDAO.updateSeccion(seccion);
		}
		
	}

	@Override
	public void saveOrUpdateSeccion(long idSeccion, String descripcion,	int estado) throws Exception {
		Seccion seccion = new Seccion(idSeccion,descripcion,estado);
		seccionDAO.updateSeccion(seccion);
	}

	@Override
	public void deleteSeccion(long idSeccion) throws Exception {
		Seccion seccion = seccionDAO.findById(idSeccion);
		if(seccion!=null)
			seccionDAO.removeSeccion(seccion);
	}

	

}