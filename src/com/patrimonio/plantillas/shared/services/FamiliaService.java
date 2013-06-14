package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.patrimonio.plantillas.shared.DTOs.FamiliaDTO;

public interface FamiliaService extends RemoteService{

	public FamiliaDTO findFamilia (long idFamilia);
	public void saveFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void updateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void saveOrUpdateFamilia(long idFamilia, int seccion, int estado, String descripcion, String codigo) throws Exception;
	public void deleteFamilia(long idFamilia) throws Exception;
}
