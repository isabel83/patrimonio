package com.patrimonio.plantillas.server.Impl;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.SubfamiliasDao;
import com.patrimonio.plantillas.shared.clases.Proveedores;
import com.patrimonio.plantillas.shared.clases.Subfamilias;
import com.patrimonio.plantillas.client.services.SubfamiliaService;

public class SubfamiliaServiceImpl extends RemoteServiceServlet implements SubfamiliaService{
	public SubfamiliasDao subfamiliaDAO;
	
	@Override
	public PagingLoadResult<Subfamilias> findAll(PagingLoadConfig config){
		
		return subfamiliaDAO.getSubfamilias(config);
	}

	@Override
	public Subfamilias findSubfamilia(long idSubfamilia) {
		
		return subfamiliaDAO.findById(idSubfamilia);
	}

	@Override
	public void saveSubfamilia(long idSubfamilia, int familia, int estado,String descripcion, String codigo) throws Exception {
		
		Subfamilias subfamilia = subfamiliaDAO.findById(idSubfamilia);
		if(subfamilia==null){
			subfamilia = new Subfamilias(idSubfamilia,familia,estado,descripcion,codigo);
			subfamiliaDAO.saveSubfamilia(subfamilia);
		}
		
	}

	@Override
	public void updateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception {
		Subfamilias subfamilia = subfamiliaDAO.findById(idSubfamilia);
		if(subfamilia!=null){
			subfamilia.setId_familia(familia);
			subfamilia.setId_estado(estado);
			subfamilia.setDescripcion(descripcion);
			subfamilia.setCodigo(codigo);
			subfamiliaDAO.updateSubfamilia(subfamilia);
		}
	}

	@Override
	public void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception {
		
		Subfamilias subfamilia = new Subfamilias(idSubfamilia,familia,estado,descripcion,codigo);
		subfamiliaDAO.updateSubfamilia(subfamilia);
		
	}

	@Override
	public void deleteSubfamilia(long idSubfamilia) throws Exception {
		Subfamilias subfamilia= subfamiliaDAO.findById(idSubfamilia);
		if(subfamilia!=null){
			subfamiliaDAO.removeSubfamilia(subfamilia);
		}
	}
}
