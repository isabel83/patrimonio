package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class SeccionesDTO extends BaseModel implements Serializable{


	private Long ID_SECCION;

	private String DESCRIPCION;

	private int ID_ESTADO;
	
	public SeccionesDTO(){
		
	}
	
	public SeccionesDTO(Long id){
		set("id",id);
		this.ID_SECCION = id;
	}
	
	public SeccionesDTO(Long id, String descripcion, int estado){
		set("id", id);
		set("descripcion", descripcion);
		set("estado", estado);
		this.ID_SECCION = id;
		this.DESCRIPCION=descripcion;
		this.ID_ESTADO=estado;
	}
		
	public Long getId_seccion() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_SECCION;
		}
	}
	
	public void setId_seccion(Long id_seccion) {
		this.ID_SECCION = id_seccion;
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
	
	public int getId_estado() {
		try {
			return get("estado");
		} catch (Exception e) {
			return this.ID_ESTADO;
		}
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
}
