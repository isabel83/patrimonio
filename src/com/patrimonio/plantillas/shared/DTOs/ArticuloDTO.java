package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULOS")
public class ArticuloDTO implements Serializable{
	
	@Id
	@Column(name="ID_ARTICULO")
	private Long id;	
	
	@Column(name="ID_SECCION")
	private int seccion;
	
	@Column(name="ID_FAMILIA")
	private int familia;	
	
	@Column(name="ID_SUBFAMILIA")
	private int subFamilia;
	
	@Column(name="CODIGO")
	private int codigo;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="MARCA")
	private String marca;	
	
	@Column(name="N_MINIMO")
	private int num_min;	
	
	@Column(name="N_IDONEO")
	private int num_id;		
	
	@Column(name="OBSERVACIONES")
	private String observaciones;
	
	@Column(name="ID_ESTADO")
	private int estado;
	
	public ArticuloDTO(){
		
	}
	
	
	public ArticuloDTO(Long id){
		this.id=id;
	}
	
	
	public ArticuloDTO(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observaciones, int estado) {
		this.id=idArticulo;
		this.seccion=seccion;
		this.familia=familia;
		this.subFamilia=subFamilia;
		this.codigo=codigo;
		this.nombre=nombre;
		this.marca=marca;
		this.num_min=numMin;
		this.num_id=numIdeal;
		this.observaciones=observaciones;
		this.estado=estado;
	}


	public Long getId_articulo() {
		return id;
	}
	
	public void setId_articulo(Long id_articulo) {
		this.id = id_articulo;
	}
	
	public int getId_seccion() {
		return seccion;
	}
	
	public void setId_seccion(int id_seccion) {
		this.seccion = id_seccion;
	}
	
	public int getId_familia() {
		return familia;
	}
	
	public void setId_familia(int id_familia) {
		this.familia = id_familia;
	}
	
	public int getId_subfamilia() {
		return subFamilia;
	}
	
	public void setId_subfamilia(int id_subfamilia) {
		this.subFamilia = id_subfamilia;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getN_minimo() {
		return num_min;
	}
	
	public void setN_minimo(int n_minimo) {
		this.num_min = n_minimo;
	}
	
	public int getN_idoneo() {
		return num_id;
	}
	
	public void setN_idoneo(int n_idoneo) {
		this.num_id = n_idoneo;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}			


}
