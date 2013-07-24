package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;



public class Arti_Prov extends BaseModel implements Serializable{


	private Long ID_ARTI_PROV;	
	
	private Integer ID_ARTICULO;
	
	private Integer ID_PROVEEDOR;
	
	public Arti_Prov(){
		
	}
	
	public Arti_Prov(long id, int articulo, int proveedor){
		
		this.ID_ARTI_PROV=id;
		this.ID_ARTICULO=articulo;
		this.ID_PROVEEDOR=proveedor;
	}

	public Long getID_ARTI_PROV() {
		return ID_ARTI_PROV;
	}

	public void setID_ARTI_PROV(Long iD_ARTI_PROV) {
		ID_ARTI_PROV = iD_ARTI_PROV;
	}

	public int getID_ARTICULO() {
		return ID_ARTICULO;
	}

	public void setID_ARTICULO(int iD_ARTICULO) {
		ID_ARTICULO = iD_ARTICULO;
	}

	public int getID_PROVEEDOR() {
		return ID_PROVEEDOR;
	}

	public void setID_PROVEEDOR(int iD_PROVEEDOR) {
		ID_PROVEEDOR = iD_PROVEEDOR;
	}

	

}
