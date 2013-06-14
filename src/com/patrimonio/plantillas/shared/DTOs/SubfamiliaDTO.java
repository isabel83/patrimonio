package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SUBFAMILIAS")
public class SubfamiliaDTO implements Serializable{

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
	
	public SubfamiliaDTO(){
		
	}
	
	public SubfamiliaDTO(Long id){
		this.id=id;
	}
	
	public SubfamiliaDTO(Long id, int id_f){
		this.id=id;
		this.familia = id_f;
	}
	
	public SubfamiliaDTO(Long id, int familia, int estado, String descripcion, String codigo){
		this.id=id;
		this.familia=familia;
		this.estado=estado;
		this.descripcion=descripcion;
		this.codigo=codigo;
	}
	
	
	public Long getId_subfamilia() {
		return id;
	}
	
	public void setId_subfamilia(Long id_subfamilia) {
		this.id = id_subfamilia;
	}
	
	public int getId_familia() {
		return familia;
	}
	
	public void setId_familia(int id_familia) {
		this.familia = id_familia;
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
