package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class SeccionDTO extends BaseModel implements Serializable{


	private Long id;
	private String descripcion;
	private int estado;
	
	public SeccionDTO(){
		
	}
	
	public SeccionDTO(Long id){
		set("id",id);
		this.id = id;
	}
	
	public SeccionDTO(Long id, String descripcion, int estado){
		set("id", id);
		set("descripcion", descripcion);
		set("estado", estado);
		this.id = id;
		this.descripcion=descripcion;
		this.estado=estado;
	}
		
	public Long getId_seccion() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_seccion(Long id_seccion) {
		this.id = id_seccion;
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
	
}
