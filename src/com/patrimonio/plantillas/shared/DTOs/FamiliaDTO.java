package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "FAMILIAS")
public class FamiliaDTO implements Serializable{

	
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
	
	public FamiliaDTO(){
		
	}
	
	public FamiliaDTO(Long id){
		this.id=id;
	}
	
	public FamiliaDTO(Long id, int id_s){
		this.id = id;
		this.seccion = id_s;
	}
	
	
	public FamiliaDTO(long idFamilia, int seccion, int estado,String descripcion, String codigo) {
		this.id=idFamilia;
		this.seccion=seccion;
		this.estado=estado;
		this.descripcion=descripcion;
		this.codigo=codigo;
	}

	public Long getId_familia() {
		return id;
	}
	
	public void setId_familia(Long id_familia) {
		this.id = id_familia;
	}
	
	public int getId_seccion() {
		return seccion;
	}
	
	public void setId_seccion(int id_seccion) {
		this.seccion = id_seccion;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
