package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class SubfamiliasDTO extends BaseModel implements Serializable{

	
	private Long ID_SUBFAMILIA;

	private int ID_FAMILIA;

	private int ID_ESTADO;

	private String DESCRIPCION;

	private String CODIGO;
	public SubfamiliasDTO(){
		
	}
	
	public SubfamiliasDTO(Long id){
		set("id", id);
		this.ID_SUBFAMILIA=id;
	}
	
	public SubfamiliasDTO(Long id, int id_f){
		set("id", id);
		set("familia", id_f);
		this.ID_SUBFAMILIA=id;
		this.ID_FAMILIA = id_f;
	}
	
	public SubfamiliasDTO(Long id, int familia, int estado, String descripcion, String codigo){
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
	
	
	public Long getId_subfamilia() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_SUBFAMILIA;
		}
	}
	
	public void setId_subfamilia(Long id_subfamilia) {
		this.ID_SUBFAMILIA = id_subfamilia;
	}
	
	public int getId_familia() {
		try {
			return get("familia");
		} catch (Exception e) {
			return this.ID_FAMILIA;
		}
	}
	
	public void setId_familia(int id_familia) {
		this.ID_FAMILIA = id_familia;
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
	
	public String getCodigo() {
		try {
			return get("codigo");
		} catch (Exception e) {
			return this.CODIGO;
		}
	}
	
	public void setCodigo(String codigo) {
		this.CODIGO = codigo;
	}
}
