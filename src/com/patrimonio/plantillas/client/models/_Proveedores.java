package com.patrimonio.plantillas.client.models;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class _Proveedores extends BaseModelData{

	public _Proveedores(){
		
	}
	
	public _Proveedores(Long id, String nif, String nombre){
		setId_proveedor(id);
		setNif(nif);
		setNombre(nombre);
	}
	
	public Long getId_proveedor() {
		return get("id");
	}
	
	public void setId_proveedor(Long id_proveedor) {
		set("id",id_proveedor);
	}
	
	public String getNif() {
		return get("nif");
	}
	public void setNif(String nif) {
		set("nif",nif);
	}
	
	public String getNombre() {
		return get("nombre");
	}
	
	public void setNombre(String nombre) {
		set("nombre",nombre);
	}
}
