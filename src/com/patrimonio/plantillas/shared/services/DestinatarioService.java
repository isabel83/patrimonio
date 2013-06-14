package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.patrimonio.plantillas.shared.DTOs.DestinatarioDTO;

public interface DestinatarioService extends RemoteService{

	public DestinatarioDTO findDestinatario (long idDestinatario);
	public void saveDestinatario(long idDestinatario, int estado, String descripcion) throws Exception;
	public void updateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception;
	public void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception;
	public void deleteDestinatario(long idDestinatario) throws Exception;
	

}
