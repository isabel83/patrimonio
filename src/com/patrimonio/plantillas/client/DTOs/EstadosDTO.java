package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class EstadosDTO extends BaseModel implements Serializable{


	private Long ID_ESTADO;
	private String DESCRIPCION;
	
	public EstadosDTO(){
		
	}
	
	public EstadosDTO(long id, String descripcion){
		set("id", id);
		set("descripcion", descripcion);
		this.ID_ESTADO= id;
		this.DESCRIPCION=descripcion;
	}

	public Long getId_estado() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_ESTADO;
		}
	}
	
	public void setId_estado(Long id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
	public String getDescripcion() {
		try {
			return get("descripcion");
		} catch (Exception e) {
			return this.DESCRIPCION;
		}
	}
	
	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}
	
}
