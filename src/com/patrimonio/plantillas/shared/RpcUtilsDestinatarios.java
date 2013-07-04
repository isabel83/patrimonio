package com.patrimonio.plantillas.shared;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.DestinatarioService;
import com.patrimonio.plantillas.client.services.DestinatarioServiceAsync;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public class RpcUtilsDestinatarios {

	DestinatarioServiceAsync destService = GWT.create(DestinatarioService.class);

	

	
	public void checkValuesAndSaveDestinatario(String nombre, Boolean est) {
		int estado = 0;
		if(est) estado = 1;
		Log.debug("vamos a generar el destinatario");
		Destinatarios dest = loadDestinatario(nombre, estado);
		Log.debug("El destinatario vale: " + dest);
		guardaDestinatario(dest);
		
	}
	
	private Destinatarios loadDestinatario(String nombre, int estado) {
		Destinatarios destinatario = new Destinatarios();
		destinatario.setDescripcion(nombre);
		destinatario.setId_estado(estado);
		return destinatario;
	}

	private void guardaDestinatario(Destinatarios dest) {
		Log.debug("Ahora llamamos a la funcion del servicio para guardar el dest");
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
		
	}


}
