package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class DestinatariosDTO extends BaseModel implements Serializable{

	private Long ID_DESTINATARIO;
	private int ID_ESTADO;
	private String DESCRIPCION;
	
	public DestinatariosDTO(){
		
	}
	
	public DestinatariosDTO(long id, int estado, String descripcion){
		set("id", id);
		set("estado", estado);
		set("descripcion", descripcion);
		this.ID_DESTINATARIO=id;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
	}
	
	public Long getId_destinatario() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_DESTINATARIO;
		}
	}
	
	public void setId_destinatario(Long id_destinatario) {
		this.ID_DESTINATARIO = id_destinatario;
	}
	
	public int getId_estado() {
		try {
			return get("estado");
		} catch (Exception e) {
			return this.ID_ESTADO;
		}
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
	
	public String getDescripcion() {
		try {
			return get("descripcion");
		} catch (Exception e) {
			return this.DESCRIPCION;
		}
	}
	
	public void setDescripcion(String descripcion) {
		this.DESCRIPCION = descripcion;
	}
	
	
}
