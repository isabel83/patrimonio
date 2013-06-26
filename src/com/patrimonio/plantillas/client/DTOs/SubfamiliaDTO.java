package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;

public class SubfamiliaDTO extends BaseModel implements Serializable{

	
	private Long id;
	private int familia;
	private int estado;
	private String descripcion;
	private String codigo;
	
	public SubfamiliaDTO(){
		
	}
	
	public SubfamiliaDTO(Long id){
		set("id", id);
		this.id=id;
	}
	
	public SubfamiliaDTO(Long id, int id_f){
		set("id", id);
		set("familia", id_f);
		this.id=id;
		this.familia = id_f;
	}
	
	public SubfamiliaDTO(Long id, int familia, int estado, String descripcion, String codigo){
		set("id", id);
		set("familia", familia);
		set("estado", estado);
		set("descripcion", descripcion);
		set("codigo", codigo);
		this.id=id;
		this.familia=familia;
		this.estado=estado;
		this.descripcion=descripcion;
		this.codigo=codigo;
	}
	
	
	public Long getId_subfamilia() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_subfamilia(Long id_subfamilia) {
		this.id = id_subfamilia;
	}
	
	public int getId_familia() {
		try {
			return get("familia");
		} catch (Exception e) {
			return this.familia;
		}
	}
	
	public void setId_familia(int id_familia) {
		this.familia = id_familia;
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
	
	public String getCodigo() {
		try {
			return get("codigo");
		} catch (Exception e) {
			return this.codigo;
		}
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
