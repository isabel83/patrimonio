package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ArticulosDTO;

public class Articulos extends BaseModel implements Serializable{
	
	private Long ID_ARTICULO;	
	
	private int ID_SECCION;
	
	private int ID_FAMILIA;	
	
	private int ID_SUBFAMILIA;
	
	private int CODIGO;
	
	private String NOMBRE;
	
	private String MARCA;	//no requerido
	
	private int N_MINIMO;	//no requerido 
	
	private int N_IDONEO;		//no requerido
	
	private String OBSERVACIONES; //no requerido
	
	private int ID_ESTADO;
	
	public Articulos(){
		
	}
	
	
	public Articulos(Long id){
		this.ID_ARTICULO=id;
	}
	
	
	public Articulos(int seccion, int familia, int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observaciones, int estado) {
		
		this.ID_SECCION=seccion;
		this.ID_FAMILIA=familia;
		this.ID_SUBFAMILIA=subFamilia;
		this.CODIGO=codigo;
		this.NOMBRE=nombre;
		this.MARCA=marca;
		this.N_MINIMO=numMin;
		this.N_IDONEO=numIdeal;
		this.OBSERVACIONES=observaciones;
		this.ID_ESTADO=estado;
	}
	
	public Articulos(ArticulosDTO articulo){
		this.ID_ARTICULO=articulo.getID_ARTICULO();
		this.ID_SECCION=articulo.getID_SECCION();
		this.ID_FAMILIA=articulo.getID_FAMILIA();
		this.ID_SUBFAMILIA=articulo.getID_SUBFAMILIA();
		this.CODIGO=articulo.getCODIGO();
		this.NOMBRE=articulo.getNOMBRE();
		this.MARCA=articulo.getMARCA();
		this.N_MINIMO=articulo.getN_MINIMO();
		this.N_IDONEO=articulo.getN_IDONEO();
		this.OBSERVACIONES=articulo.getOBSERVACIONES();
		this.ID_ESTADO=articulo.getID_ESTADO();
	}
		
		

	public Long getId_articulo() {
//		try {
//			return get("idArticulo");
//		} catch (Exception e) {
			return this.ID_ARTICULO;
//		}
	}
	
	public void setId_articulo(Long id_articulo) {
		this.ID_ARTICULO = id_articulo;
	}
	
	public int getId_seccion() {
//		try {
//			return get("seccion");
//		} catch (Exception e) {
			return this.ID_SECCION;
//		}
	}
	
	public void setId_seccion(int id_seccion) {
		this.ID_SECCION = id_seccion;
	}
	
	public int getId_familia() {
//		try {
//			return get("familia");
//		} catch (Exception e) {
			return this.ID_FAMILIA;
//		}
	}
	
	public void setId_familia(int id_familia) {
		this.ID_FAMILIA = id_familia;
	}
	
	public int getId_subfamilia() {
//		try {
//			return get("subFamilia");
//		} catch (Exception e) {
			return this.ID_SUBFAMILIA;
//		}
	}
	
	public void setId_subfamilia(int id_subfamilia) {
		this.ID_SUBFAMILIA = id_subfamilia;
	}
	
	public int getCodigo() {
//		try {
//			return get("codigo");
//		} catch (Exception e) {
			return this.CODIGO;
//		}
	}
	
	public void setCodigo(int codigo) {
		this.CODIGO = codigo;
	}
	
	public String getNombre() {
//		try {
//			return get("nombre");
//		} catch (Exception e) {
			return this.NOMBRE;
//		}
	}
	
	public void setNombre(String nombre) {
		this.NOMBRE = nombre;
	}
	
	public String getMarca() {
//		try {
//			return get("marca");
//		} catch (Exception e) {
			return this.MARCA;
//		}
	}
	
	public void setMarca(String marca) {
		this.MARCA = marca;
	}
	
	public int getN_minimo() {
//		try {
//			return get("num_min");
//		} catch (Exception e) {
			return this.N_MINIMO;
//		}
	}
	
	public void setN_minimo(int n_minimo) {
		this.N_MINIMO = n_minimo;
	}
	
	public int getN_idoneo() {
//		try {
//			return get("num_id");
//		} catch (Exception e) {
			return this.N_IDONEO;
//		}
	}
	
	public void setN_idoneo(int n_idoneo) {
		this.N_IDONEO = n_idoneo;
	}
	
	public String getObservaciones() {
//		try {
//			return get("observaciones");
//		} catch (Exception e) {
			return this.OBSERVACIONES;
//		}
	}
	
	public void setObservaciones(String observaciones) {
		this.OBSERVACIONES = observaciones;
	}
	
	public int getId_estado() {
//		try {
//			return get("estado");
//		} catch (Exception e) {
			return this.ID_ESTADO;
//		}
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}			


}
