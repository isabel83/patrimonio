package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PuestoDTO;

@Entity
@Table(name = "PUESTOS")
public class Puesto extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_PUESTOS")
	private Long id;

	@Column(name="ID_ESTADO")
	private int estado;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	public Puesto(){
		
	}
	
	public Puesto(long id){
		set("id", id);
		this.id=id;
	}
	
	public Puesto(long id, int estado, String descripcion){
		set("id",id);
		set("estado",estado);
		set("descripcion",descripcion);	
		this.id=id;
		this.estado=estado;
		this.descripcion=descripcion;
	}
	
	public Puesto(PuestoDTO puesto){
		this.id=puesto.getId_puesto();
		this.estado=puesto.getId_estado();
		this.descripcion=puesto.getDescripcion();
	}
	
	public Long getId_puesto() {
		return this.id;
	}
	
	public void setId_puesto(Long id_puesto) {
		this.id = id_puesto;
	}
	
	public int getId_estado() {
		return this.estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
