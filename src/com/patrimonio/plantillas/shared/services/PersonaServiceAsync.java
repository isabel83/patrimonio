package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.PersonaDTO;

public interface PersonaServiceAsync {

	void findPersona(long idPersona, AsyncCallback<PersonaDTO> callback);

	void savePersona(long idPersona, int estado, int perfil, String descripcion, AsyncCallback<Void> callback);

	void deletePersona(long idPersona, AsyncCallback<Void> callback);

	void saveOrUpdatePersona(long idPersona, int estado, int perfil, String descripcion, AsyncCallback<Void> callback);

	void updatePersona(long idPersona, int estado, int perfil, String descripcion, AsyncCallback<Void> callback);

}
