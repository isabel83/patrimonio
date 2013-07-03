package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Expedientes extends BaseModel implements Serializable{
	
	private Long ID_EXPEDIENTE;
	private int ANO;
	private String EXPEDIENTE;
	private String DESCRIPCION;
	private int ID_EXPEDIENTE_TIPO;
	
	public Expedientes(){
		
	}
	
	public Expedientes(Long id, int anyo, String expediente, String descripcion, int id_tipo){
		this.ID_EXPEDIENTE=id;
		this.ANO=anyo;
		this.EXPEDIENTE=expediente;
		this.DESCRIPCION=descripcion;
		this.ID_EXPEDIENTE_TIPO=id_tipo;
	}
	
	public Long getID_EXPEDIENTE() {
		return ID_EXPEDIENTE;
	}
	public void setID_EXPEDIENTE(Long iD_EXPEDIENTE) {
		ID_EXPEDIENTE = iD_EXPEDIENTE;
	}
	public int getANO() {
		return ANO;
	}
	public void setANO(int aNO) {
		ANO = aNO;
	}
	public String getEXPEDIENTE() {
		return EXPEDIENTE;
	}
	public void setEXPEDIENTE(String eXPEDIENTE) {
		EXPEDIENTE = eXPEDIENTE;
	}
	public String getDESCRIPCION() {
		return DESCRIPCION;
	}
	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}
	public int getID_EXPEDIENTE_TIPO() {
		return ID_EXPEDIENTE_TIPO;
	}
	public void setID_EXPEDIENTE_TIPO(int iD_EXPEDIENTE_TIPO) {
		ID_EXPEDIENTE_TIPO = iD_EXPEDIENTE_TIPO;
	}

}
