package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.SeccionesDTO;


public class Secciones extends BaseModel implements Serializable{

	private Long ID_SECCION;

	private String DESCRIPCION;

	private int ID_ESTADO;
	
	public Secciones(){
		
	}
	
	public Secciones(Long id){
		set("id",id);
		this.ID_SECCION = id;
	}
	
	public Secciones(Long id, String descripcion, int estado){
		set("id", id);
		set("descripcion", descripcion);
		set("estado", estado);
		this.ID_SECCION = id;
		this.DESCRIPCION=descripcion;
		this.ID_ESTADO=estado;
	}
	
	public Secciones(SeccionesDTO seccion){
		this.ID_SECCION=seccion.getId_seccion();
		this.DESCRIPCION=seccion.getDescripcion();
		this.ID_ESTADO=seccion.getId_estado();
	}
		
	public Long getId_seccion() {
		return this.ID_SECCION;
	}
	
	public void setId_seccion(Long id_seccion) {
		this.ID_SECCION = id_seccion;
	}
	
	public String getDescripcion() {
		return this.DESCRIPCION;
	}
	
	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}
	
	public int getId_estado() {
		return this.ID_ESTADO;
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
}
