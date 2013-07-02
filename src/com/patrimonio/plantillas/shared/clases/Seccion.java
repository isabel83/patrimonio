package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.SeccionDTO;


@Entity
@Table(name = "SECCIONES")
public class Seccion extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_SECCION")
	private Long id;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="ID_ESTADO")
	private int estado;
	
	public Seccion(){
		
	}
	
	public Seccion(Long id){
		set("id",id);
		this.id = id;
	}
	
	public Seccion(Long id, String descripcion, int estado){
		set("id", id);
		set("descripcion", descripcion);
		set("estado", estado);
		this.id = id;
		this.descripcion=descripcion;
		this.estado=estado;
	}
	
	public Seccion(SeccionDTO seccion){
		this.id=seccion.getId_seccion();
		this.descripcion=seccion.getDescripcion();
		this.estado=seccion.getId_estado();
	}
		
	public Long getId_seccion() {
		return this.id;
	}
	
	public void setId_seccion(Long id_seccion) {
		this.id = id_seccion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getId_estado() {
		return this.estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
}
