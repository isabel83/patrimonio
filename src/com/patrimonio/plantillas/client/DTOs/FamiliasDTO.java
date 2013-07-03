package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class FamiliasDTO extends BaseModel implements Serializable{


	private Long ID_FAMILIA;
	
	private int ID_SECCION;
	
	private int ID_ESTADO;
	
	private String DESCRIPCION;
	
	private String CODIGO;
	
	public FamiliasDTO(){
		
	}
	
	public FamiliasDTO(Long id){
		set("id", id);
		this.ID_FAMILIA=id;
	}
	
	public FamiliasDTO(Long id, int id_s){
		set("id", id);
		set("seccion", id_s);
		this.ID_FAMILIA = id;
		this.ID_SECCION = id_s;
	}
	
	
	public FamiliasDTO(long idFamilia, int seccion, int estado,String descripcion, String codigo) {
		set("id", ID_FAMILIA);
		set("seccion", seccion);
		set("estado", estado);
		set("descripcion", descripcion);
		set("codigo", codigo);
		this.ID_FAMILIA=idFamilia;
		this.ID_SECCION=seccion;
		this.ID_ESTADO=estado;
		this.DESCRIPCION=descripcion;
		this.CODIGO=codigo;
	}

	public Long getId_familia() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_FAMILIA;
		}
	}
	
	public void setId_familia(Long id_familia) {
		this.ID_FAMILIA = id_familia;
	}
	
	public int getId_seccion() {
		try {
			return get("seccion");
		} catch (Exception e) {
			return this.ID_SECCION;
		}
	}
	
	public void setId_seccion(int id_seccion) {
		this.ID_SECCION = id_seccion;
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
