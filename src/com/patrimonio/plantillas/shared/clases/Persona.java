package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PersonaDTO;


@Entity
@Table(name = "PERSONAS")
public class Persona extends BaseModel implements Serializable{
	
	@GeneratedValue
	@Id
	@Column(name="ID_PERSONA")
	private Long id;

	@Column(name="ID_ESTADO")	
	private int estado;

	@Column(name="ID_PERFIL")
	private int perfil;

	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public Persona(){
		
	}
	
	public Persona(Long id, int id_p){
		set("id",id);
		this.id = id;
	}
	

	public Persona(Long id, int id_e, int id_p, String descripcion){
		set("id", id);
		set("estado", id_e);
		set("perfil", id_p);
		set("descripcion", descripcion);
		this.id = id;
		this.estado = id_e;
		this.perfil = id_p;
		this.descripcion=descripcion;
	}
	
	public Persona(PersonaDTO persona){
		this.id=persona.getId_persona();
		this.estado = persona.getId_estado();
		this.perfil=persona.getId_perfil();
		this.descripcion=persona.getDescripcion();
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
