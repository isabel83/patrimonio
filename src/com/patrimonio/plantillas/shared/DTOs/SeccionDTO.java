package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SECCIONES")
public class SeccionDTO implements Serializable{

	@Id
	@Column(name="ID_SECCION")
	private Long id;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="ID_ESTADO")
	private int estado;
	
	public SeccionDTO(){
		
	}
	
	public SeccionDTO(Long id){
		this.id = id;
	}
	
	public SeccionDTO(Long id, String descripcion, int estado){
		this.id = id;
		this.descripcion=descripcion;
		this.estado=estado;
	}
		
	public Long getId_seccion() {
		return id;
	}
	
	public void setId_seccion(Long id_seccion) {
		this.id = id_seccion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
}
