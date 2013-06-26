package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.EstadoDTO;

@Entity
@Table(name = "ESTADOS")
public class Estado extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_ESTADO")
	private Long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public Estado(){
		
	}
	
	public Estado(long id, String descripcion){
		set("id", id);
		set("descripcion", descripcion);
		this.id= id;
		this.descripcion=descripcion;
	}

	public Estado(EstadoDTO estado){
		this.id=estado.getId_estado();
		this.descripcion=estado.getDescripcion();
	}
	
	public Long getId_estado() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_estado(Long id_estado) {
		this.id = id_estado;
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
