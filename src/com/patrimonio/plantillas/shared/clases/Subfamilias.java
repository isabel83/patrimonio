package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;


public class Subfamilias extends BaseModel implements Serializable{

	private Long ID_SUBFAMILIA; //todos requeridos

	private Integer ID_FAMILIA;

	private Integer ID_ESTADO;

	private String DESCRIPCION;

	private String CODIGO;
	
	public Subfamilias(){
		
	}
	
	public Subfamilias(Long id){
		this.ID_SUBFAMILIA=id;
	}
	
	public Subfamilias(Long id, int id_f){
		this.ID_SUBFAMILIA=id;
		this.ID_FAMILIA = id_f;
	}
	
	public Subfamilias(int familia, int estado, String descripcion, String codigo){
		this.ID_FAMILIA=familia;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
		this.CODIGO=codigo;
	}
	
	
	
	public Long getId_subfamilia() {
		return this.ID_SUBFAMILIA;
	}
	
	public void setId_subfamilia(Long id_subfamilia) {
		this.ID_SUBFAMILIA = id_subfamilia;
	}
	
	public int getId_familia() {
		return this.ID_FAMILIA;
	}
	
	public void setId_familia(int id_familia) {
		this.ID_FAMILIA = id_familia;
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
