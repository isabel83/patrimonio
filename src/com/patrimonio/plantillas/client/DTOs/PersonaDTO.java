package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class PersonaDTO extends BaseModel implements Serializable{
	

	private Long id;	
	private int estado;
	private int perfil;
	private String descripcion;
	
	public PersonaDTO(){
		
	}
	
	public PersonaDTO(Long id, int id_p){
		set("id",id);
		this.id = id;
	}
	

	public PersonaDTO(Long id, int id_e, int id_p, String descripcion){
		set("id", id);
		set("estado", id_e);
		set("perfil", id_p);
		set("descripcion", descripcion);
		this.id = id;
		this.estado = id_e;
		this.perfil = id_p;
		this.descripcion=descripcion;
	}
	
	public Long getId_persona() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_persona(Long id_persona) {
		this.id = id_persona;
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
	
	public int getId_perfil() {
		try {
			return get("perfil");
		} catch (Exception e) {
			return this.perfil;
		}
	}
	
	public void setId_perfil(int id_perfil) {
		this.perfil = id_perfil;
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
