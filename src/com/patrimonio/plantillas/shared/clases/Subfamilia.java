package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.SubfamiliaDTO;


@Entity
@Table(name = "SUBFAMILIAS")
public class Subfamilia extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_SUBFAMILIA")
	private Long id;

	@Column(name="ID_FAMILIA")
	private int familia;

	@Column(name="ID_ESTADO")
	private int estado;

	@Column(name="DESCRIPCION")
	private String descripcion;

	@Column(name="CODIGO")
	private String codigo;
	
	public Subfamilia(){
		
	}
	
	public Subfamilia(Long id){
		set("id", id);
		this.id=id;
	}
	
	public Subfamilia(Long id, int id_f){
		set("id", id);
		set("familia", id_f);
		this.id=id;
		this.familia = id_f;
	}
	
	public Subfamilia(Long id, int familia, int estado, String descripcion, String codigo){
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
	
	
	public Subfamilia(SubfamiliaDTO subfamilia){
		this.id=subfamilia.getId_subfamilia();
		this.familia=subfamilia.getId_familia();
		this.estado=subfamilia.getId_estado();
		this.descripcion=subfamilia.getDescripcion();
		this.codigo=subfamilia.getCodigo();
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
