package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.PersonaService;
import com.patrimonio.plantillas.client.services.PersonaServiceAsync;
import com.patrimonio.plantillas.shared.clases.Personas;

public class RpcUtilsPersonas {
	PersonaServiceAsync personasService = GWT.create(PersonaService.class);

	public void checkValuesAndSavePersona(String nombre, int perfil) {
		Personas fam = new Personas(nombre,perfil,0);
		guardaPersona(fam);
	}

	private void guardaPersona(Personas persona) {
		personasService.savePersona(persona, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox guardado = new MessageBox();
				guardado.setMessage("Ha habido un error guardando los datos, revise los campos");
				guardado.setIcon(MessageBox.ERROR);
				guardado.setTitle("Atención");
				guardado.show();
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				MessageBox guardado = new MessageBox();
				guardado.setMessage("La persona ha sido guardada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
		
	}

	public void loadPersonasCombo(final ListStore personas) {
		personasService.findAllForList(new AsyncCallback<List<Personas>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("Error en carga de personas: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Personas> result) {
				Log.debug("Estamos en el on success de personas hay: " + result.size());
				for(Personas per: result){
						
					 BaseModel model = new BaseModel();
	                 model.set("id",per.getId_persona());
	                 model.set("nombre", per.getDescripcion());
					 personas.add(model);
				} 
				
				
			}
			
		});
	}

	public void deletePersona(long persona) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
