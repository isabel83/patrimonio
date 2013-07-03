package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class PersonasDTO extends BaseModel implements Serializable{
	

	private Long ID_PERSONA;

	private int ID_ESTADO;

	private int ID_PERFIL;

	private String DESCRIPCION;
	
	public PersonasDTO(){
		
	}
	
	public PersonasDTO(Long id, int id_p){
		set("id",id);
		this.ID_PERSONA = id;
	}
	

	public PersonasDTO(Long id, int id_e, int id_p, String descripcion){
		set("id", id);
		set("estado", id_e);
		set("perfil", id_p);
		set("descripcion", descripcion);
		this.ID_PERSONA = id;
		this.ID_ESTADO = id_e;
		this.ID_PERFIL = id_p;
		this.DESCRIPCION=descripcion;
	}
	
	public Long getId_persona() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_PERSONA;
		}
	}
	
	public void setId_persona(Long id_persona) {
		this.ID_PERSONA = id_persona;
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
	
	public int getId_perfil() {
		try {
			return get("perfil");
		} catch (Exception e) {
			return this.ID_PERFIL;
		}
	}
	
	public void setId_perfil(int id_perfil) {
		this.ID_PERFIL = id_perfil;
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
