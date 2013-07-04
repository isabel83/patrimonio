package com.patrimonio.plantillas.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

@RemoteServiceRelativePath("destinatario")
public interface DestinatarioService extends RemoteService{

	public Destinatarios findDestinatario (long idDestinatario);
	public void saveDestinatario(Destinatarios destinatario) throws Exception;
	public void updateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception;
	public void saveOrUpdateDestinatario(long idDestinatario, int estado, String descripcion) throws Exception;
	public void deleteDestinatario(long idDestinatario) throws Exception;
	

}
