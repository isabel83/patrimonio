package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PersonasDTO;


public class Personas extends BaseModel implements Serializable{
	
	private Long ID_PERSONA;

	private int ID_ESTADO;

	private int ID_PERFIL;

	private String DESCRIPCION;
	
	public Personas(){
		
	}
	
	public Personas(Long id, int id_p){
		this.ID_PERSONA = id;
	}
	

	public Personas(Long id, int id_e, int id_p, String descripcion){
		this.ID_PERSONA = id;
		this.ID_ESTADO = id_e;
		this.ID_PERFIL = id_p;
		this.DESCRIPCION=descripcion;
	}
	
	public Personas(PersonasDTO persona){
		this.ID_PERSONA=persona.getId_persona();
		this.ID_ESTADO = persona.getId_estado();
		this.ID_PERFIL=persona.getId_perfil();
		this.DESCRIPCION=persona.getDescripcion();
	}
	
	public Long getId_persona() {
		return this.ID_PERSONA;
	}
	
	public void setId_persona(Long id_persona) {
		this.ID_PERSONA = id_persona;
	}
	
	public int getId_estado() {
		return this.ID_ESTADO;
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
	public int getId_perfil() {
		return this.ID_PERFIL;
	}
	
	public void setId_perfil(int id_perfil) {
		this.ID_PERFIL = id_perfil;
	}
	
	public String getDescripcion() {
		return this.DESCRIPCION;
	}
	
	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	} 
	

}
