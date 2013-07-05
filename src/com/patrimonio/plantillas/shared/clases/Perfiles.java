package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PerfilesDTO;


public class Perfiles extends BaseModel implements Serializable{

	private Long ID_PERFIL; //requeridos
	
	private String DESCRIPCION;
	
	public Perfiles(){
		
	}
	
	public Perfiles(long id, String descripcion){
	
		this.ID_PERFIL=id;
		this.DESCRIPCION=descripcion;
	}
	
	public Perfiles(PerfilesDTO perfil){
		this.ID_PERFIL=perfil.getID_PERFIL();
		this.DESCRIPCION=perfil.getDESCRIPCION();
	}
	
	public Long getId_perfil() {
		return this.ID_PERFIL;
	}
	
	public void setId_perfil(Long id_perfil) {
		this.ID_PERFIL = id_perfil;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}

	
	

}
