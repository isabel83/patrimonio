package com.patrimonio.plantillas.shared;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.shared.clases.Articulo;
import com.patrimonio.plantillas.shared.clases.Proveedor;
import com.patrimonio.plantillas.client.DTOs.ProveedorDTO;
import com.patrimonio.plantillas.client.services.ArticuloService;
import com.patrimonio.plantillas.client.services.ArticuloServiceAsync;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.client.services.ProveedorServiceAsync;

public class RpcUtils {
	
	ProveedorServiceAsync proService = GWT.create(ProveedorService.class);
	ArticuloServiceAsync articuloService = GWT.create(ArticuloService.class);
	
	public void loadProveedores(final ListBox lstProveedores,PagingLoadConfig loadConfig){
		
		
		proService.findAll(loadConfig, new AsyncCallback<PagingLoadResult<Proveedor>>(){

			@Override
			public void onFailure(Throwable caught) {
				
				
			}

			@Override
			public void onSuccess(PagingLoadResult<Proveedor> result) {
//				for(Proveedor pro: result){
//					//SI QUEDA MUY LARGO PONER EL NIF EN UN CAMPO A PARTE
//					lstProveedores.addItem(pro.getNombre() + " - " + pro.getNif(), pro.getId_proveedor().toString());
//				} 
				
			}
			
		});
		
	}

	public void loadArticulosProveedor(final ListBox lstArticulos, int idProveedor) {
		
		articuloService.loadArticulosPro(idProveedor, new AsyncCallback<List<Articulo>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Articulo> result) {
				for(Articulo articulo: result){
					lstArticulos.addItem(articulo.getNombre(), articulo.getId_articulo().toString());
				}
				
			}
			
		});
	}

	public List<Proveedor> loadProveedoresCombo() {
		Log.debug("Estamos en la funcion de load en shared");
		final List<Proveedor> lista = new ArrayList<Proveedor>();
		proService.findAllForList(new AsyncCallback<List<Proveedor>>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println();
			}

			@Override
			public void onSuccess(List<Proveedor> result) {
				Log.debug("Estamos en el on success");
				lista.addAll(result); 
				
			}
			
		});
		
		return lista;
	}

	public void guardaProveedor(Proveedor prov) {
		proService.saveProveedor(prov, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("ERROR: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				
			}
			
		});
	}


	
}
