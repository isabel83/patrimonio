package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;


public class Secciones extends BaseModel implements Serializable{

	private Long ID_SECCION; //todos requeridos

	private String DESCRIPCION;

	private Integer ID_ESTADO;
	
	public Secciones(){
		
	}
	
	
	public Secciones(String descripcion, int estado){
		set("descripcion", descripcion);
		set("estado", estado);
		this.DESCRIPCION=descripcion;
		this.ID_ESTADO=estado;
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
