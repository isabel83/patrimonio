package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESTINATARIOS")
public class DestinatarioDTO implements Serializable{

	@Id
	@Column(name="ID_DESTINATARIO")
	private Long id;
	
	@Column(name="ID_ESTADO")
	private int estado;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public DestinatarioDTO(){
		
	}
	
	public DestinatarioDTO(long id, int estado, String descripcion){
		this.id=id;
		this.estado=estado;
		this.descripcion=descripcion;
	}
	
	public Long getId_destinatario() {
		return id;
	}
	
	public void setId_destinatario(Long id_destinatario) {
		this.id = id_destinatario;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
