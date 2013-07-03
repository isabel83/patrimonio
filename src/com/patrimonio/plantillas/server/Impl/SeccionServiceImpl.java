package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.SeccionesDao;
import com.patrimonio.plantillas.shared.clases.Secciones;
import com.patrimonio.plantillas.client.services.SeccionService;

public class SeccionServiceImpl extends RemoteServiceServlet implements SeccionService{
	
	public SeccionesDao seccionDAO;

	@Override
	public PagingLoadResult<Secciones> findAll(PagingLoadConfig config) {
		
		return seccionDAO.getSecciones(config);
	}
	
	@Override
	public Secciones findSeccion(long idSeccion) {
		
		return seccionDAO.findById(idSeccion);
	}

	@Override
	public void saveSeccion(long idSeccion, String descripcion, int estado)	throws Exception {
		Secciones seccion = seccionDAO.findById(idSeccion);
		if(seccion==null){
			seccion = new Secciones(idSeccion, descripcion, estado);
			seccionDAO.saveSeccion(seccion);
		}
		
	}

	@Override
	public void updateSeccion(long idSeccion, String descripcion, int estado) throws Exception {
		Secciones seccion = seccionDAO.findById(idSeccion);
		if(seccion!=null){
			seccion.setDescripcion(descripcion);
			seccion.setId_estado(estado);
			seccionDAO.updateSeccion(seccion);
		}
		
	}

	@Override
	public void saveOrUpdateSeccion(long idSeccion, String descripcion,	int estado) throws Exception {
		Secciones seccion = new Secciones(idSeccion,descripcion,estado);
		seccionDAO.updateSeccion(seccion);
	}

	@Override
	public void deleteSeccion(long idSeccion) throws Exception {
		Secciones seccion = seccionDAO.findById(idSeccion);
		if(seccion!=null)
			seccionDAO.removeSeccion(seccion);
	}

	

}