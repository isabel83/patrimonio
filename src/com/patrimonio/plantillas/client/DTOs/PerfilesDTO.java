package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class PerfilesDTO extends BaseModel implements Serializable{

private Long ID_PERFIL;
	
	private String DESCRIPCION;
	
	
	public PerfilesDTO(){
		
	}
	
	public PerfilesDTO(long id, String descripcion){
		
		this.ID_PERFIL=id;
		this.DESCRIPCION = descripcion;
	}

	public Long getID_PERFIL() {
		return ID_PERFIL;
	}

	public void setID_PERFIL(Long iD_PERFIL) {
		ID_PERFIL = iD_PERFIL;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	
	
}
