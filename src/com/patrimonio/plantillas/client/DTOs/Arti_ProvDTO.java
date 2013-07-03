package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class Arti_ProvDTO extends BaseModel implements Serializable{

	private Long id;	
	private int articulo;
	private int proveedor;

	public Arti_ProvDTO(long id, int articulo, int proveedor){
		set("id",id);
		set("articulo",articulo);
		set("proveedor",proveedor);
		this.id=id;
		this.articulo=articulo;
		this.proveedor=proveedor;
	}
	
	public Long getId() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getArticulo() {
		try {
			return get("articulo");
		} catch (Exception e) {
			return this.articulo;
		}
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}

	public int getProveedor() {
		try {
			return get("proveedor");
		} catch (Exception e) {
			return this.proveedor;
		}
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}	
}
