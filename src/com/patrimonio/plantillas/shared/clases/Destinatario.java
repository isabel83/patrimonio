package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.DestinatarioDTO;

@Entity
@Table(name = "DESTINATARIOS")
public class Destinatario extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_DESTINATARIO")
	private Long id;
	
	@Column(name="ID_ESTADO")
	private int estado;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public Destinatario(){
		
	}
	
	public Destinatario(long id, int estado, String descripcion){
		set("id", id);
		set("estado", estado);
		set("descripcion", descripcion);
		this.id=id;
		this.estado=estado;
		this.descripcion=descripcion;
	}
	
	public Destinatario(DestinatarioDTO destinatario){
		this.id=destinatario.getId_destinatario();
		this.estado=destinatario.getId_estado();
		this.descripcion=destinatario.getDescripcion();
	}
	
	public Long getId_destinatario() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_destinatario(Long id_destinatario) {
		this.id = id_destinatario;
	}
	
	public int getId_estado() {
		try {
			return get("estado");
		} catch (Exception e) {
			return this.estado;
		}
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
	public String getDescripcion() {
		try {
			return get("descripcion");
		} catch (Exception e) {
			return this.descripcion;
		}
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
