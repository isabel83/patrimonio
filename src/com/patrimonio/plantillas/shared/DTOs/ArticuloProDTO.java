package com.patrimonio.plantillas.shared.DTOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTI_PROV")
public class ArticuloProDTO {

	@Id
	@Column(name="ID_ARTI_PROV")
	private Long id;	
	
	@Column(name="ID_ARTICULO")
	private int articulo;
	
	@Column(name="ID_PROVEEDOR")
	private int proveedor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getArticulo() {
		return articulo;
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}	
}
