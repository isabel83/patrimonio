package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Puestos extends BaseModel implements Serializable{

	private Long ID_PUESTO; //todos requeridos

	private Integer ID_ESTADO;
	
	private String DESCRIPCION;
	
	public Puestos(){
		
	}
	
	public Puestos(long id){
		this.ID_PUESTO=id;
	}
	
	public Puestos(int estado, String descripcion){
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
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
