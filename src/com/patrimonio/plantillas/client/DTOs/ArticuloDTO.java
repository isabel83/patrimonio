package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class ArticuloDTO extends BaseModel implements Serializable{

	private Long id;
	private int seccion;
	private int familia;	
	private int subFamilia;
	private int codigo;
	private String nombre;
	private String marca;	
	private int num_min;	
	private int num_id;		
	private String observaciones;
	private int estado;
	
	public ArticuloDTO(){
		
	}
	
	
	public ArticuloDTO(Long id){
		set("idArticulo", id);
		this.id=id;
	}
	
	
	public ArticuloDTO(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observaciones, int estado) {
		set("idArticulo", idArticulo);
		set("seccion", seccion);
		set("familia", familia);
		set("subFamilia", subFamilia);
		set("codigo", codigo);
		set("nombre", nombre);
		set("marca", marca);
		set("num_min", numMin);
		set("num_ideal",numIdeal);
		set("observaciones", observaciones);
		set("estado", estado);
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
		try {
			return get("idArticulo");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_articulo(Long id_articulo) {
		this.id = id_articulo;
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
	
	public int getId_subfamilia() {
		try {
			return get("subFamilia");
		} catch (Exception e) {
			return this.subFamilia;
		}
	}
	
	public void setId_subfamilia(int id_subfamilia) {
		this.subFamilia = id_subfamilia;
	}
	
	public int getCodigo() {
		try {
			return get("codigo");
		} catch (Exception e) {
			return this.codigo;
		}
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		try {
			return get("nombre");
		} catch (Exception e) {
			return this.nombre;
		}
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		try {
			return get("marca");
		} catch (Exception e) {
			return this.marca;
		}
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getN_minimo() {
		try {
			return get("num_min");
		} catch (Exception e) {
			return this.num_min;
		}
	}
	
	public void setN_minimo(int n_minimo) {
		this.num_min = n_minimo;
	}
	
	public int getN_idoneo() {
		try {
			return get("num_id");
		} catch (Exception e) {
			return this.num_id;
		}
	}
	
	public void setN_idoneo(int n_idoneo) {
		this.num_id = n_idoneo;
	}
	
	public String getObservaciones() {
		try {
			return get("observaciones");
		} catch (Exception e) {
			return this.observaciones;
		}
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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


}
