package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class EstadoDTO extends BaseModel implements Serializable{


	private Long id;
	private String descripcion;
	
	public EstadoDTO(){
		
	}
	
	public EstadoDTO(long id, String descripcion){
		set("id", id);
		set("descripcion", descripcion);
		this.id= id;
		this.descripcion=descripcion;
	}

	public Long getId_estado() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_estado(Long id_estado) {
		this.id = id_estado;
	}
	
	public String getDescripcion() {
		try {
			return get("descripcion");
		} catch (Exception e) {
			return this.descripcion;
		}
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
