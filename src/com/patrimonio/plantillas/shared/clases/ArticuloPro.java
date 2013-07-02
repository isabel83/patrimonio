package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ArticuloProDTO;

@Entity
@Table(name = "ARTI_PROV")
public class ArticuloPro extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_ARTI_PROV")
	private Long id;	
	
	@Column(name="ID_ARTICULO")
	private int articulo;
	
	@Column(name="ID_PROVEEDOR")
	private int proveedor;

	public ArticuloPro(long id, int articulo, int proveedor){
		set("id",id);
		set("articulo",articulo);
		set("proveedor",proveedor);
		this.id=id;
		this.articulo=articulo;
		this.proveedor=proveedor;
	}
	
	public ArticuloPro(ArticuloProDTO articulopro){
		this.id= articulopro.getId();
		this.articulo=articulopro.getArticulo();
		this.proveedor=articulopro.getProveedor();
	}
	
	public Long getId() {
			return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getArticulo() {
			return this.articulo;
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}

	public int getProveedor() {
			return this.proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}	
}
