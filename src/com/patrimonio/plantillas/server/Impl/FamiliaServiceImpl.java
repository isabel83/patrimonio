package com.patrimonio.plantillas.server.Impl;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.FamiliasDao;
import com.patrimonio.plantillas.shared.clases.Familias;
import com.patrimonio.plantillas.client.services.FamiliaService;

public class FamiliaServiceImpl extends RemoteServiceServlet implements FamiliaService{
	
	public FamiliasDao familiaDAO = new FamiliasDao();
	
	@Override
	public PagingLoadResult<Familias> findAll(PagingLoadConfig config){
		return familiaDAO.getFamilias(config);
	}

	@Override
	public Familias findFamilia(long idFamilia) {
		return familiaDAO.findById(idFamilia);
	}

	@Override
	public void saveFamilia(Familias familia) throws Exception {
		familiaDAO.saveFamilia(familia);
	}

	@Override
	public void updateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception {
		Familias familia = familiaDAO.findById(idFamilia);
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
		
//		Familias familia = new Familias(idFamilia,seccion,estado,descripcion,codigo);
//		familiaDAO.updateFamilia(familia);
//		
	}

	@Override
	public void deleteFamilia(long idFamilia) throws Exception {
		Familias familia = familiaDAO.findById(idFamilia);
		if(familia!=null){
			familiaDAO.removeFamilia(familia);
		}
	}

	@Override
	public List<Familias> findAllForList() throws Exception {
		return familiaDAO.findAll();
	}

}
 