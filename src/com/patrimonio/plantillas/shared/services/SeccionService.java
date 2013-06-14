package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.patrimonio.plantillas.shared.DTOs.SeccionDTO;

public interface SeccionService extends RemoteService{

	public SeccionDTO findSeccion (long idSeccion);
	public void saveSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void updateSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void saveOrUpdateSeccion(long idSeccion, String descripcion, int estado) throws Exception;
	public void deleteSeccion(long idSeccion) throws Exception;
	
}
