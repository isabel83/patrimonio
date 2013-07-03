package com.patrimonio.plantillas.client.DTOs;

public class Expedientes_TiposDTO {
	private Long ID_EXPEDIENTE_TIPO;
	private String DESCRIPCION;
	
	public Expedientes_TiposDTO(){
		
	}
	
	public Expedientes_TiposDTO(Long id, String descripcion){
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
