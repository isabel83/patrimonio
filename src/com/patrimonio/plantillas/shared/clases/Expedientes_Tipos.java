package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Expedientes_Tipos implements Serializable {

	private Long ID_EXPEDIENTE_TIPO;
	private String DESCRIPCION;
	
	public Expedientes_Tipos(){
		
	}
	
	public Expedientes_Tipos(Long id, String descripcion){
		this.ID_EXPEDIENTE_TIPO=id;
		this.DESCRIPCION=descripcion;
	}

	public Long getID_EXPEDIENTE_TIPO() {
		return ID_EXPEDIENTE_TIPO;
	}

	public void setID_EXPEDIENTE_TIPO(Long iD_EXPEDIENTE_TIPO) {
		ID_EXPEDIENTE_TIPO = iD_EXPEDIENTE_TIPO;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
}
