package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERSONAS")
public class PersonaDTO implements Serializable{
	
	@Id
	@Column(name="ID_PERSONA")
	private Long id;

	@Column(name="ID_ESTADO")	
	private int estado;

	@Column(name="ID_PERFIL")
	private int perfil;

	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public PersonaDTO(){
		
	}
	
	public PersonaDTO(Long id, int id_p){
		this.id = id;
	}
	

	public PersonaDTO(Long id, int id_e, int id_p, String descripcion){
		this.id = id;
		this.estado = id_e;
		this.perfil = id_p;
		this.descripcion=descripcion;
	}
	
	public Long getId_persona() {
		return id;
	}
	
	public void setId_persona(Long id_persona) {
		this.id = id_persona;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
	public int getId_perfil() {
		return perfil;
	}
	
	public void setId_perfil(int id_perfil) {
		this.perfil = id_perfil;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
	

}
