package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PuestosDTO;

public class Puestos extends BaseModel implements Serializable{

	private Long ID_PUESTO; //todos requeridos

	private int ID_ESTADO;
	
	private String DESCRIPCION;
	
	public Puestos(){
		
	}
	
	public Puestos(long id){
		this.ID_PUESTO=id;
	}
	
	public Puestos(long id, int estado, String descripcion){
		this.ID_PUESTO=id;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
	}
	
	public Puestos(PuestosDTO puesto){
		this.ID_PUESTO=puesto.getId_puesto();
		this.ID_ESTADO=puesto.getId_estado();
		this.DESCRIPCION=puesto.getDescripcion();
	}
	
	public Long getId_puesto() {
		return this.ID_PUESTO;
	}
	
	public void setId_puesto(Long id_puesto) {
		this.ID_PUESTO = id_puesto;
	}
	
	public int getId_estado() {
		return this.ID_ESTADO;
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
	public String getDescripcion() {
		return this.DESCRIPCION;
	}
	
	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}
}
