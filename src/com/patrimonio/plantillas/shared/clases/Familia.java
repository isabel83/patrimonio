package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;


@Entity
@Table(name = "FAMILIAS")
public class Familia extends BaseModel implements Serializable{

	
	@GeneratedValue
	@Id
	@Column(name="ID_FAMILIA")
	private Long id;
	
	@Column(name="ID_SECCION")
	private int seccion;
	
	@Column(name="ID_ESTADO")
	private int estado;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="CODIGO")
	private String codigo;
	
	public Familia(){
		
	}
	
	public Familia(Long id){
		set("id", id);
		this.id=id;
	}
	
	public Familia(Long id, int id_s){
		set("id", id);
		set("seccion", id_s);
		this.id = id;
		this.seccion = id_s;
	}
	
	
	public Familia(long idFamilia, int seccion, int estado,String descripcion, String codigo) {
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
		return this.seccion;
	}
	
	public void setId_seccion(int id_seccion) {
		this.seccion = id_seccion;
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
	
	public String getCodigo() {
			return this.codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
