package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.SeccionService;
import com.patrimonio.plantillas.client.services.SeccionServiceAsync;
import com.patrimonio.plantillas.shared.clases.Proveedores;
import com.patrimonio.plantillas.shared.clases.Secciones;

public class RpcUtilsSecciones {
	
	SeccionServiceAsync secService = GWT.create(SeccionService.class);

	public void checkValuesAndSaveSecciones(String nombre) {
		Secciones seccion = new Secciones(nombre, 1); //siempre activo al guardar
		guardarSeccion(seccion);
	}

	private void guardarSeccion(Secciones seccion) {
		secService.saveSeccion(seccion, new AsyncCallback<Void>(){

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
				guardado.setMessage("La sección ha sido guardada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
	}

	public void loadSeccionesCombo(final ListStore secciones) {
		secService.findAllForList(new AsyncCallback<List<Secciones>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Secciones> result) {
				Log.debug("Estamos en el on success, hay: " + result.size());
				for(Secciones sec: result){
						
					 BaseModel model = new BaseModel();
	                 model.set("id",sec.getId_seccion());
	                 model.set("nombre", sec.getDescripcion());
					 secciones.add(model);
				} 
				
				
			}
			
		});
	}

	public void deleteSeccion(long seccion) {
		// TODO Auto-generated method stub
		
	}
}
