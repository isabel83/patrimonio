package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.patrimonio.plantillas.shared.DTOs.PuestoDTO;

public interface PuestoService extends RemoteService{

	public PuestoDTO findPuesto (long idPuesto);
	public void savePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void updatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void saveOrUpdatePuesto(long idPuesto, int estado, String descripcion) throws Exception;
	public void deletePuesto(long idPuesto) throws Exception;
}
