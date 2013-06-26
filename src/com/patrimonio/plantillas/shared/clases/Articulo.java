package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ArticuloDTO;

@Entity
@Table(name = "ARTICULOS")
public class Articulo extends BaseModel implements Serializable{
	
	@GeneratedValue
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
	
	public Articulo(){
		
	}
	
	
	public Articulo(Long id){
		set("idArticulo", id);
		this.id=id;
	}
	
	
	public Articulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca,
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
	
	public Articulo(ArticuloDTO articulo){
		this.id=articulo.getId_articulo();
		this.seccion=articulo.getId_seccion();
		this.familia=articulo.getId_familia();
		this.subFamilia=articulo.getId_subfamilia();
		this.codigo=articulo.getCodigo();
		this.nombre=articulo.getNombre();
		this.marca=articulo.getMarca();
		this.num_min=articulo.getN_minimo();
		this.num_id=articulo.getN_idoneo();
		this.observaciones=articulo.getObservaciones();
		this.estado=articulo.getId_estado();
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
