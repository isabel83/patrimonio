package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.PuestosDao;
import com.patrimonio.plantillas.shared.clases.Puestos;
import com.patrimonio.plantillas.client.services.PuestoService;

public class PuestoServiceImpl extends RemoteServiceServlet implements PuestoService{
	
	public PuestosDao puestoDAO;
	
	@Override
	public PagingLoadResult<Puestos> findAll(PagingLoadConfig config){
		return puestoDAO.getPuestos(config);
	}

	@Override
	public Puestos findPuesto(long idPuesto) {
		return puestoDAO.findById(idPuesto);
	}

	@Override
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puestos puesto = puestoDAO.findById(idPuesto);
		if(puesto==null){
			puesto = new Puestos(idPuesto,estado,descripcion);
			puestoDAO.savePuesto(puesto);
		}
		
	}

	@Override
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puestos puesto = puestoDAO.findById(idPuesto);
		if(puesto!=null){
			puesto.setDescripcion(descripcion);
			puesto.setId_estado(estado);
			puestoDAO.updatePuesto(puesto);
		}
		
	}

	@Override
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception {
		Puestos puesto = new Puestos(idPuesto,estado,descripcion);
		puestoDAO.updatePuesto(puesto);
		
	}

	@Override
	public void deletePuesto(long idPuesto) throws Exception {
		Puestos puesto = puestoDAO.findById(idPuesto);
		if(puesto!=null)
			puestoDAO.removePuesto(puesto);
		
	}

}
