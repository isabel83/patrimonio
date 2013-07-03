package com.patrimonio.plantillas.shared;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.shared.clases.Articulos;
import com.patrimonio.plantillas.shared.clases.Proveedores;
import com.patrimonio.plantillas.client.DTOs.ProveedoresDTO;
import com.patrimonio.plantillas.client.services.ArticuloService;
import com.patrimonio.plantillas.client.services.ArticuloServiceAsync;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.client.services.ProveedorServiceAsync;

public class RpcUtils {
	
	ProveedorServiceAsync proService = GWT.create(ProveedorService.class);
	ArticuloServiceAsync articuloService = GWT.create(ArticuloService.class);
	protected int total;
	
	public void loadProveedores(final ListBox lstProveedores,PagingLoadConfig loadConfig){
		
		
		proService.findAll(loadConfig, new AsyncCallback<PagingLoadResult<Proveedores>>(){

			@Override
			public void onFailure(Throwable caught) {
				
				
			}

			@Override
			public void onSuccess(PagingLoadResult<Proveedores> result) {
//				for(Proveedor pro: result){
//					//SI QUEDA MUY LARGO PONER EL NIF EN UN CAMPO A PARTE
//					lstProveedores.addItem(pro.getNombre() + " - " + pro.getNif(), pro.getId_proveedor().toString());
//				} 
				
			}
			
		});
		
	}

	public void loadArticulosProveedor(final ListBox lstArticulos, int idProveedor) {
		
		articuloService.loadArticulosPro(idProveedor, new AsyncCallback<List<Articulos>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Articulos> result) {
				for(Articulos articulo: result){
					lstArticulos.addItem(articulo.getNombre(), articulo.getId_articulo().toString());
				}
				
			}
			
		});
	}

	public void loadProveedoresCombo(final ListStore proveedores) {
		Log.debug("Estamos en la funcion de load en shared");
		proService.findAllForList(new AsyncCallback<List<Proveedores>>(){

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Proveedores> result) {
				Log.debug("Estamos en el on success, hay: " + result.size());
				for(Proveedores pro: result){
					Log.debug("Proveedor: " + pro.getId_proveedor() + " , " + pro.getNombre());
						
					 BaseModel model = new BaseModel();
	                 model.set("id",pro.getId_proveedor());
	                 model.set("nombre", pro.getNombre());
					 proveedores.add(model);
				} 
				
				
			}
			
		});
	}
	
	//VALIDAMOS QUE LOS CAMPOS ESTEN CORRECTOS  
		public void checkValuesAndSaveProveedor(String nif, String nombre, String actividad, String contacto, String domicilio, 
				String poblacion, int cp, String provincia, String tfno, String tfno2, String fax, int movil, String correo, boolean estado) {
			Log.debug("En la funcion de check");
			
			int est=0;
			if(estado){
				est=1;
			}
			else{
				est = 0;
			}
			
			
			//Chequeamos los campos obligatorios
			
			
			Log.debug("Vamos a cargar los datos en el proveedor");
			Proveedores prov = loadProveedor(nif, nombre, actividad, contacto, domicilio, poblacion, cp, provincia, tfno, tfno2, fax, movil, correo, est);
			guardaProveedor(prov);
			
			
		}

		//AQUI LOS CAMPOS YA SE HAN VALIDADO, GUARDAMOS LOS VALORES Y ENVIAMOS A LA BBDD
		public Proveedores loadProveedor(String nif, String nombre, String actividad, String contacto, String domicilio, 
				String poblacion, int cp, String provincia, String tfno, String tfno2, String fax, int movil, String correo, int estado) {
			
			Proveedores proveedor = new Proveedores();
			proveedor.setNif(nif);
			proveedor.setNombre(nombre);
			proveedor.setActividad(actividad);
			proveedor.setContacto(contacto);
			proveedor.setDomicilio(domicilio);
			proveedor.setPoblacion(poblacion);
			proveedor.setCp(cp);
			proveedor.setProvincia(provincia);
			proveedor.setTlf1(tfno);
			proveedor.setTlf2(tfno2);
			proveedor.setMovil(movil);
			proveedor.setFax(fax);
			proveedor.setEmail(correo);
			proveedor.setId_estado(estado);
			
			Log.debug("Hemos cargado el proveedor: " + proveedor);
			
			return proveedor;
		}

	

	public void guardaProveedor(Proveedores prov) {
		Log.debug("Ya tenemos el proveedor vamso a guardarlo");
		proService.saveProveedor(prov, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("ERROR: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(Void result) {
				System.out.println("GUARADO");
				MessageBox guardado = new MessageBox();
				guardado.setMessage("El proveedor ha sido guardado");
				guardado.setIcon(MessageBox.INFO);
				guardado.setTitle("Guardado");
				guardado.show();
			}
			
		});
	}

	public void deleteProveedor(long idProveedor) {

		proService.deleteProveedor(idProveedor, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	
	public int countAll() {

		
		proService.findAllForList(new AsyncCallback<List<Proveedores>>(){

			

			@Override
			public void onFailure(Throwable caught) {
				Log.debug("Error en carga de proveedores: " + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(List<Proveedores> result) {
				total = result.size();
			} 
			
		});
		return total;
	}

	

	
}
