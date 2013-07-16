package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.DestinatarioService;
import com.patrimonio.plantillas.client.services.DestinatarioServiceAsync;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public class RpcUtilsDestinatarios {

	DestinatarioServiceAsync destService = GWT.create(DestinatarioService.class);
	Destinatarios destinatario= new Destinatarios();
	
	public void checkValuesAndSaveDestinatario(String nombre, Boolean tienePuesto) {
		
		Destinatarios dest = loadDestinatario(nombre, 1);
		guardaDestinatario(dest);
		
	}
	
	public Destinatarios cargaDestinatario(long id) {
		destService.findDestinatario(id, new AsyncCallback<Destinatarios>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox guardado = new MessageBox();
				guardado.setMessage("El destinatario no existe");
				guardado.setIcon(MessageBox.ERROR);
				guardado.setTitle("Atención");
				guardado.show();
				 
			}

			@Override
			public void onSuccess(Destinatarios result) {
				destinatario = result;				
			}
			
		});
		return destinatario;
	}
	
	
	private Destinatarios loadDestinatario(String nombre, int estado) {
		Destinatarios destinatario = new Destinatarios();
		destinatario.setDescripcion(nombre);
		destinatario.setId_estado(estado);
		return destinatario;
	}

	private void guardaDestinatario(Destinatarios dest) {
		destService.saveDestinatario(dest,  new AsyncCallback<Void>(){

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
				guardado.setMessage("El destinatario ha sido guardado");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
		
	}

	

	public void deleteDestinatario(long idDestinatario) {
		//chequeamos si tiene asociadas familias y las deshabilitamos
		destService.deleteDestinatario(idDestinatario, new AsyncCallback<Void>(){
			@Override
			public void onFailure(Throwable caught) {
				MessageBox guardado = new MessageBox();
				guardado.setMessage("Ha habido un error eliminando este destinatario");
				guardado.setIcon(MessageBox.ERROR);
				guardado.setTitle("Atención");
				guardado.show();
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				MessageBox guardado = new MessageBox();
				guardado.setMessage("El destinatario ha sido eliminado");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Eliminado");
				guardado.show();
			}
		});
	
	}

	public void loadUnidadCombo(final ListStore<BaseModel> unidades) {
		destService.findAllForList(new AsyncCallback<List<Destinatarios>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Destinatarios> result) {
				Log.debug("Estamos en el on success, hay: " + result.size());
				for(Destinatarios des: result){
						
					 BaseModel model = new BaseModel();
	                 model.set("id",des.getId_destinatario());
	                 model.set("nombre", des.getDescripcion());
					 unidades.add(model);
				} 
				
				
			}
			
		});
		
	}


}
