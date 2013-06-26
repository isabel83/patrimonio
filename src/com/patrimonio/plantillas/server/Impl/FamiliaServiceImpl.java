package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.FamiliaDao;
import com.patrimonio.plantillas.shared.clases.Familia;
import com.patrimonio.plantillas.client.services.FamiliaService;

public class FamiliaServiceImpl extends RemoteServiceServlet implements FamiliaService{
	
	public FamiliaDao familiaDAO;
	
	@Override
	public PagingLoadResult<Familia> findAll(PagingLoadConfig config){
		return familiaDAO.getFamilias(config);
	}

	@Override
	public Familia findFamilia(long idFamilia) {
		
		return familiaDAO.findById(idFamilia);
	}

	@Override
	public void saveFamilia(long idFamilia, int seccion, int estado,String descripcion, String codigo) throws Exception {
		
		Familia familia = familiaDAO.findById(idFamilia);
		if(familia==null){
			familia = new Familia(idFamilia,seccion,estado,descripcion,codigo);
			familiaDAO.saveFamilia(familia);
		}
		
	}

	@Override
	public void updateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception {
		Familia familia = familiaDAO.findById(idFamilia);
		if(familia!=null){
			familia.setId_seccion(seccion);
			familia.setId_estado(estado);
			familia.setDescripcion(descripcion);
			familia.setCodigo(codigo);
			familiaDAO.updateFamilia(familia);
		}
	}

	@Override
	public void saveOrUpdateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception {
		
		Familia familia = new Familia(idFamilia,seccion,estado,descripcion,codigo);
		familiaDAO.updateFamilia(familia);
		
	}

	@Override
	public void deleteFamilia(long idFamilia) throws Exception {
		Familia familia = familiaDAO.findById(idFamilia);
		if(familia!=null){
			familiaDAO.removeFamilia(familia);
		}
	}

}
 