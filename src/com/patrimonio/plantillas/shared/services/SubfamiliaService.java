package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.DTOs.SubfamiliaDTO;

@RemoteServiceRelativePath("subfamilia")
public interface SubfamiliaService extends RemoteService{

	public SubfamiliaDTO findSubfamilia (long idSubfamilia);
	public void saveSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception;
	public void updateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception;
	public void saveOrUpdateSubfamilia(long idSubfamilia, int familia, int estado, String descripcion, String codigo) throws Exception;
	public void deleteSubfamilia(long idSubfamilia) throws Exception;
	
}
