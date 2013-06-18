package com.patrimonio.plantillas.shared;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;
import com.patrimonio.plantillas.shared.DTOs.ProveedorDTO;
import com.patrimonio.plantillas.shared.services.ArticuloService;
import com.patrimonio.plantillas.shared.services.ArticuloServiceAsync;
import com.patrimonio.plantillas.shared.services.ProveedorService;
import com.patrimonio.plantillas.shared.services.ProveedorServiceAsync;

public class RpcUtils {

	public void loadProveedores(final ListBox lstProveedores){
		ProveedorServiceAsync proService = GWT.create(ProveedorService.class);
		
		proService.findAll(new AsyncCallback<List<ProveedorDTO>>(){

			@Override
			public void onFailure(Throwable caught) {
				
				
			}

			@Override
			public void onSuccess(List<ProveedorDTO> result) {
				for(ProveedorDTO pro: result){
					//SI QUEDA MUY LARGO PONER EL NIF EN UN CAMPO A PARTE
					lstProveedores.addItem(pro.getNombre() + " - " + pro.getNif(), pro.getId_proveedor().toString());
				} 
				
			}
			
		});
		
	}

	public void loadArticulosProveedor(final ListBox lstArticulos, int idProveedor) {
		ArticuloServiceAsync articuloService = GWT.create(ArticuloService.class);
		articuloService.loadArticulosPro(idProveedor, new AsyncCallback<List<ArticuloDTO>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<ArticuloDTO> result) {
				for(ArticuloDTO articulo: result){
					lstArticulos.addItem(articulo.getNombre(), articulo.getId_articulo().toString());
				}
				
			}
			
		});
	}


	
}
