package com.patrimonio.plantillas.shared;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.services.ArticuloService;
import com.patrimonio.plantillas.client.services.ArticuloServiceAsync;
import com.patrimonio.plantillas.shared.clases.Articulos;

public class RpcUtilsArticulos {
	ArticuloServiceAsync articuloService = GWT.create(ArticuloService.class);
	protected List<Articulos> filtrados= null;

	public void checkValuesAndSaveArticulo(int seccion, int familia, int subfamilia, int codigoArt, String nombreArt, String marcaArt,
			String obsArt, int minimas,int idoneas) {
				
		Articulos articulo = new Articulos(seccion,familia,subfamilia,codigoArt,nombreArt,marcaArt,minimas,idoneas,obsArt,1);
		guardaArticulo(articulo);
		
	}

	private void guardaArticulo(Articulos articulo) {
		articuloService.saveArticulo(articulo, new AsyncCallback<Void>(){

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
				guardado.setMessage("El artículo ha sido guardado");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
		
	}

	public List<Articulos> findByCriterio(Articulos articuloBusqueda) {
		
		articuloService.findByCriterios(articuloBusqueda, new AsyncCallback<List<Articulos>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Articulos> result) {
				filtrados = result;
				
			}
			
		});
		
		return filtrados;
	}

	public void loadArticulosCombo(final ListStore<BaseModel> articulos, int idProv) {
		if(idProv>0){
			articuloService.loadArticulosPro(idProv,new AsyncCallback<List<Articulos>>(){
				
				@Override
				public void onFailure(Throwable caught) {
					Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
				}
	
				@Override
				public void onSuccess(List<Articulos> result) {
					Log.debug("Estamos en el on success, hay: " + result.size());
					for(Articulos arti: result){
						 BaseModel model = new BaseModel();
		                 model.set("id",arti.getId_articulo());
		                 model.set("nombre", arti.getNombre());
						 articulos.add(model);
					} 
					
					
				}
				
			});
		}
//		articuloService.findAllForList(new AsyncCallback<List<Articulos>>(){
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
//			}
//
//			@Override
//			public void onSuccess(List<Articulos> result) {
//				Log.debug("Estamos en el on success, hay: " + result.size());
//				for(Articulos arti: result){
//						
//					 BaseModel model = new BaseModel();
//	                 model.set("id",arti.getId_articulo());
//	                 model.set("nombre", arti.getNombre());
//					 articulos.add(model);
//				} 
//				
//				
//			}
//			
//		});
		
	}

//	public Pedidos loadArticuloGrid(Articulos seleccionado) {
//		return seleccionado;
//		
//		
//	}
}
