package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS")
public class EstadoDTO implements Serializable{

	@Id
	@Column(name="ID_ESTADO")
	private Long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public EstadoDTO(){
		
	}
	
	public EstadoDTO(long id, String descripcion){
		this.id= id;
		this.descripcion=descripcion;
	}

	public Long getId_estado() {
		return id;
	}
	
	public void setId_estado(Long id_estado) {
		this.id = id_estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
