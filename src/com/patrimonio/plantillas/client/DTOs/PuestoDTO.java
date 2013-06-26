package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class PuestoDTO extends BaseModel implements Serializable{


	private Long id;
	private int estado;
	private String descripcion;
	
	public PuestoDTO(){
		
	}
	
	public PuestoDTO(long id){
		set("id", id);
		this.id=id;
	}
	
	public PuestoDTO(long id, int estado, String descripcion){
		set("id",id);
		set("estado",estado);
		set("descripcion",descripcion);	
		this.id=id;
		this.estado=estado;
		this.descripcion=descripcion;
	}
	
	public Long getId_puesto() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_puesto(Long id_puesto) {
		this.id = id_puesto;
	}
	
	public int getId_estado() {
		try {
			return get("estado");
		} catch (Exception e) {
			return this.estado;
		}
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
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
