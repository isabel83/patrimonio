package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Subfamilias;

@RemoteServiceRelativePath("subfamilia")
public interface SubfamiliaService extends RemoteService{
	
	public PagingLoadResult<Subfamilias> findAll(PagingLoadConfig config);
	public Subfamilias findSubfamilia (long idSubfamilia);
	public void saveSubfamilia(Subfamilias subfamilia) throws Exception;
	public void updateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception;
	public void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception;
	public void deleteSubfamilia(long idSubfamilia) throws Exception;
	public List<Subfamilias> findAllForList() throws Exception;
}
