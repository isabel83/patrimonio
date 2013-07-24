package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Destinatarios extends BaseModel implements Serializable{

	private Long ID_DESTINATARIO;
	
	private Integer ID_ESTADO;
	
	private String DESCRIPCION; //todos requeridos
	
	public Destinatarios(){
		
	}
	
	public Destinatarios(int estado, String descripcion){
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
	}
	
	public Long getId_destinatario() {
			return this.ID_DESTINATARIO;
	}
	
	public void setId_destinatario(Long id_destinatario) {
		this.ID_DESTINATARIO = id_destinatario;
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
