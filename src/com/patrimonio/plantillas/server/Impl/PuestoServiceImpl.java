package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.PuestoDao;
import com.patrimonio.plantillas.shared.clases.Puesto;
import com.patrimonio.plantillas.client.services.PuestoService;

public class PuestoServiceImpl extends RemoteServiceServlet implements PuestoService{
	
	public PuestoDao puestoDAO;
	
	@Override
	public PagingLoadResult<Puesto> findAll(PagingLoadConfig config){
		return puestoDAO.getPuestos(config);
	}

	@Override
	public Puesto findPuesto(long idPuesto) {
		return puestoDAO.findById(idPuesto);
	}

	@Override
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puesto puesto = puestoDAO.findById(idPuesto);
		if(puesto==null){
			puesto = new Puesto(idPuesto,estado,descripcion);
			puestoDAO.savePuesto(puesto);
		}
		
	}

	@Override
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puesto puesto = puestoDAO.findById(idPuesto);
		if(puesto!=null){
			puesto.setDescripcion(descripcion);
			puesto.setId_estado(estado);
			puestoDAO.updatePuesto(puesto);
		}
		
	}

	@Override
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puesto puesto = new Puesto(idPuesto,estado,descripcion);
		puestoDAO.updatePuesto(puesto);
		
	}

	@Override
	public void deletePuesto(long idPuesto) throws Exception {
		Puesto puesto = puestoDAO.findById(idPuesto);
		if(puesto!=null)
			puestoDAO.removePuesto(puesto);
		
	}

}
