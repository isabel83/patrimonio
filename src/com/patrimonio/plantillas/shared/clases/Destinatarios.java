package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.DestinatariosDTO;

public class Destinatarios extends BaseModel implements Serializable{

	private Long ID_DESTINATARIO;
	
	private int ID_ESTADO;
	
	private String DESCRIPCION;
	
	public Destinatarios(){
		
	}
	
	public Destinatarios(long id, int estado, String descripcion){
		set("id", id);
		set("estado", estado);
		set("descripcion", descripcion);
		this.ID_DESTINATARIO=id;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
	}
	
	public Destinatarios(DestinatariosDTO destinatario){
		this.ID_DESTINATARIO=destinatario.getId_destinatario();
		this.ID_ESTADO=destinatario.getId_estado();
		this.DESCRIPCION=destinatario.getDescripcion();
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
