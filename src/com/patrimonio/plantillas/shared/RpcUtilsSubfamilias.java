package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.SubfamiliaService;
import com.patrimonio.plantillas.client.services.SubfamiliaServiceAsync;
import com.patrimonio.plantillas.shared.clases.Subfamilias;

public class RpcUtilsSubfamilias {
	SubfamiliaServiceAsync subFamService = GWT.create(SubfamiliaService.class);

	public void checkValuesAndSaveSubFamilia(String nombre, String codigo, int familia) {
		Subfamilias subF = new Subfamilias(familia,1,nombre,codigo);
		guardaSubF(subF);
	}

	private void guardaSubF(Subfamilias subF) {
		subFamService.saveSubfamilia(subF, new AsyncCallback<Void>(){

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
				guardado.setMessage("La subfamilia ha sido guardada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
		
	}

	public void loadSubFamiliasComboFiltrado(final ListStore<BaseModel> subFamilia, final long familia) {
		subFamService.findAllForList(new AsyncCallback<List<Subfamilias>>(){

			@Override
			public void onFailure(Throwable caught) {
				//Log.debug("Error en carga de familias: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Subfamilias> result) {
				//Log.debug("Estamos en el on success de familias hay: " + result.size());
				for(Subfamilias sub: result){
					if(sub.getId_familia()==familia){	
						 BaseModel model = new BaseModel();
		                 model.set("id",sub.getId_subfamilia());
		                 model.set("nombre", sub.getDescripcion());
						 subFamilia.add(model);
					}
				} 
				
				
			}
			
		});
	}
	
	
	public void deleteSubfamilia(long subfamilia){
		subFamService.deleteSubfamilia(subfamilia, new AsyncCallback<Void>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox guardado = new MessageBox();
				guardado.setMessage("Ha habido un error eliminando la subfamilia");
				guardado.setIcon(MessageBox.ERROR);
				guardado.setTitle("Atención");
				guardado.show();
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				MessageBox guardado = new MessageBox();
				guardado.setMessage("La subfamilia ha sido eliminada");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Eliminado");
				guardado.show();
			}
		});
	}
}
