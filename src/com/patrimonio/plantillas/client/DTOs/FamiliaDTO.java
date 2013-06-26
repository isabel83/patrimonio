package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class FamiliaDTO extends BaseModel implements Serializable{


	private Long id;
	private int seccion;
	private int estado;
	private String descripcion;
	private String codigo;
	
	public FamiliaDTO(){
		
	}
	
	public FamiliaDTO(Long id){
		set("id", id);
		this.id=id;
	}
	
	public FamiliaDTO(Long id, int id_s){
		set("id", id);
		set("seccion", id_s);
		this.id = id;
		this.seccion = id_s;
	}
	
	
	public FamiliaDTO(long idFamilia, int seccion, int estado,String descripcion, String codigo) {
		set("id", id);
		set("seccion", seccion);
		set("estado", estado);
		set("descripcion", descripcion);
		set("codigo", codigo);
		this.id=idFamilia;
		this.seccion=seccion;
		this.estado=estado;
		this.descripcion=descripcion;
		this.codigo=codigo;
	}

	public Long getId_familia() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_familia(Long id_familia) {
		this.id = id_familia;
	}
	
	public int getId_seccion() {
		try {
			return get("seccion");
		} catch (Exception e) {
			return this.seccion;
		}
	}
	
	public void setId_seccion(int id_seccion) {
		this.seccion = id_seccion;
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
