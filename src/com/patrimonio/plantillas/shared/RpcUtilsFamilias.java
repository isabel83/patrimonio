package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.FamiliaService;
import com.patrimonio.plantillas.client.services.FamiliaServiceAsync;
import com.patrimonio.plantillas.shared.clases.Familias;

public class RpcUtilsFamilias {
	
	FamiliaServiceAsync familiasService = GWT.create(FamiliaService.class);

	public void checkValuesAndSaveFamilia(String nombre, String codigo,	int seccion) {
		Familias fam = new Familias(seccion,1,nombre,codigo);
		guardaFamilia(fam);
	}

	private void guardaFamilia(Familias fam) {
		familiasService.saveFamilia(fam, new AsyncCallback<Void>(){

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
				guardado.setMessage("La familia ha sido guardada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
		
	}

	public void loadFamiliasCombo(final ListStore<BaseModel> familias) {
		familiasService.findAllForList(new AsyncCallback<List<Familias>>(){

			@Override
			public void onFailure(Throwable caught) {
				//Log.debug("Error en carga de familias: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Familias> result) {
				//Log.debug("Estamos en el on success de familias hay: " + result.size());
				for(Familias fam: result){
						
					 BaseModel model = new BaseModel();
	                 model.set("id",fam.getId_familia());
	                 model.set("nombre", fam.getDescripcion());
					 familias.add(model);
				} 
				
				
			}
			
		});
	}

	public void deleteFamilia(long familia) {
		familiasService.deleteFamilia(familia, new AsyncCallback<Void>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox guardado = new MessageBox();
				guardado.setMessage("Ha habido un error eliminando esta familia");
				guardado.setIcon(MessageBox.ERROR);
				guardado.setTitle("Atención");
				guardado.show();
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				MessageBox guardado = new MessageBox();
				guardado.setMessage("La familia ha sido eliminada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Eliminado");
				guardado.show();
			}
		});
		
	}

	public void loadFamiliasComboFiltrado(final ListStore<BaseModel> familias, final long seccion) {
		familiasService.findAllForList(new AsyncCallback<List<Familias>>(){

			@Override
			public void onFailure(Throwable caught) {
				//Log.debug("Error en carga de familias: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Familias> result) {
				//Log.debug("Estamos en el on success de familias hay: " + result.size());
				for(Familias fam: result){
					if(fam.getId_seccion()==seccion){	
						 BaseModel model = new BaseModel();
		                 model.set("id",fam.getId_familia());
		                 model.set("nombre", fam.getDescripcion());
						 familias.add(model);
					}
				} 
				
				
			}
			
		});
		
	}

	
	
}
