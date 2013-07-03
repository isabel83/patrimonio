package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class PuestosDTO extends BaseModel implements Serializable{


	private Long ID_PUESTO;

	private int ID_ESTADO;
	
	private String DESCRIPCION;
	
	public PuestosDTO(){
		
	}
	
	public PuestosDTO(long id){
		set("id", id);
		this.ID_PUESTO=id;
	}
	
	public PuestosDTO(long id, int estado, String descripcion){
		set("id",id);
		set("estado",estado);
		set("descripcion",descripcion);	
		this.ID_PUESTO=id;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
	}
	
	public Long getId_puesto() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_PUESTO;
		}
	}
	
	public void setId_puesto(Long id_puesto) {
		this.ID_PUESTO = id_puesto;
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
