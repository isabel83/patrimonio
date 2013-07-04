package com.patrimonio.plantillas.shared;

import java.util.Iterator;
import java.util.List;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
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
}
