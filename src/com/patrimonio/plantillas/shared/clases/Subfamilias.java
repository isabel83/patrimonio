package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.SubfamiliasDTO;


public class Subfamilias extends BaseModel implements Serializable{

	private Long ID_SUBFAMILIA;

	private int ID_FAMILIA;

	private int ID_ESTADO;

	private String DESCRIPCION;

	private String CODIGO;
	
	public Subfamilias(){
		
	}
	
	public Subfamilias(Long id){
		set("id", id);
		this.ID_SUBFAMILIA=id;
	}
	
	public Subfamilias(Long id, int id_f){
		set("id", id);
		set("familia", id_f);
		this.ID_SUBFAMILIA=id;
		this.ID_FAMILIA = id_f;
	}
	
	public Subfamilias(Long id, int familia, int estado, String descripcion, String codigo){
		set("id", id);
		set("familia", familia);
		set("estado", estado);
		set("descripcion", descripcion);
		set("codigo", codigo);
		this.ID_SUBFAMILIA=id;
		this.ID_FAMILIA=familia;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
		this.CODIGO=codigo;
	}
	
	
	public Subfamilias(SubfamiliasDTO subfamilia){
		this.ID_SUBFAMILIA=subfamilia.getId_subfamilia();
		this.ID_FAMILIA=subfamilia.getId_familia();
		this.ID_ESTADO=subfamilia.getId_estado();
		this.DESCRIPCION=subfamilia.getDescripcion();
		this.CODIGO=subfamilia.getCodigo();
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
