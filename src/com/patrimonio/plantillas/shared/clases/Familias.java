package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;


public class Familias extends BaseModel implements Serializable{

	
	private Long ID_FAMILIA; //todos requeridos
	
	private int ID_SECCION;
	
	private int ID_ESTADO;
	
	private String DESCRIPCION;
	
	private String CODIGO;
	
	public Familias(){
		
	}
	
	public Familias(Long id){
		this.ID_FAMILIA=id;
	}
	
	public Familias(Long id, int id_s){
		this.ID_FAMILIA = id;
		this.ID_SECCION = id_s;
	}
	
	
	public Familias(int seccion, int estado,String descripcion, String codigo) {
		this.ID_SECCION=seccion;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
		this.CODIGO=codigo;
	}

	public Long getId_familia() {
		return this.ID_FAMILIA;
	}
	
	public void setId_familia(Long id_familia) {
		this.ID_FAMILIA = id_familia;
	}
	
	public int getId_seccion() {
		return this.ID_SECCION;
	}
	
	public void setId_seccion(int id_seccion) {
		this.ID_SECCION = id_seccion;
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
	
	public String getCodigo() {
			return this.CODIGO;
	}
	
	public void setCodigo(String codigo) {
		this.CODIGO = codigo;
	}
	
}
