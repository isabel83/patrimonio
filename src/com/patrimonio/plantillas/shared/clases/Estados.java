package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.EstadosDTO;

public class Estados extends BaseModel implements Serializable{

	private Long ID_ESTADO;
	
	private String DESCRIPCION;
	
	public Estados(){
		
	}
	
	public Estados(long id, String descripcion){
		this.ID_ESTADO= id;
		this.DESCRIPCION=descripcion;
	}

	public Estados(EstadosDTO estado){
		this.ID_ESTADO=estado.getId_estado();
		this.DESCRIPCION=estado.getDescripcion();
	}
	

	public Long getID_ESTADO() {
		return ID_ESTADO;
	}

	public void setID_ESTADO(Long iD_ESTADO) {
		ID_ESTADO = iD_ESTADO;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	
}
