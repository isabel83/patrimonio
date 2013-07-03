package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class ArticulosDTO extends BaseModel implements Serializable{

private Long ID_ARTICULO;	
	
	private int ID_SECCION;
	
	private int ID_FAMILIA;	
	
	private int ID_SUBFAMILIA;
	
	private int CODIGO;
	
	private String NOMBRE;
	
	private String MARCA;	
	
	private int N_MINIMO;	
	
	private int N_IDONEO;		
	
	private String OBSERVACIONES;
	
	private int ID_ESTADO;
	
	public ArticulosDTO(){
		
	}
	
	
	public ArticulosDTO(Long id){
		this.setID_ARTICULO(id);
	}
	
	
	public ArticulosDTO(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observaciones, int estado) {

		this.setID_ARTICULO(idArticulo);
		this.setID_SECCION(seccion);
		this.setID_FAMILIA(familia);
		this.setID_SUBFAMILIA(subFamilia);
		this.setCODIGO(codigo);
		this.setNOMBRE(nombre);
		this.setMARCA(marca);
		this.setN_MINIMO(numMin);
		this.setN_IDONEO(numIdeal);
		this.setOBSERVACIONES(observaciones);
		this.setID_ESTADO(estado);
	}


	public Long getID_ARTICULO() {
		return ID_ARTICULO;
	}


	public void setID_ARTICULO(Long iD_ARTICULO) {
		ID_ARTICULO = iD_ARTICULO;
	}


	public int getID_SECCION() {
		return ID_SECCION;
	}


	public void setID_SECCION(int iD_SECCION) {
		ID_SECCION = iD_SECCION;
	}


	public int getID_FAMILIA() {
		return ID_FAMILIA;
	}


	public void setID_FAMILIA(int iD_FAMILIA) {
		ID_FAMILIA = iD_FAMILIA;
	}


	public int getID_SUBFAMILIA() {
		return ID_SUBFAMILIA;
	}


	public void setID_SUBFAMILIA(int iD_SUBFAMILIA) {
		ID_SUBFAMILIA = iD_SUBFAMILIA;
	}


	public int getCODIGO() {
		return CODIGO;
	}


	public void setCODIGO(int cODIGO) {
		CODIGO = cODIGO;
	}


	public String getNOMBRE() {
		return NOMBRE;
	}


	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}


	public String getMARCA() {
		return MARCA;
	}


	public void setMARCA(String mARCA) {
		MARCA = mARCA;
	}


	public int getN_MINIMO() {
		return N_MINIMO;
	}


	public void setN_MINIMO(int n_MINIMO) {
		N_MINIMO = n_MINIMO;
	}


	public int getN_IDONEO() {
		return N_IDONEO;
	}


	public void setN_IDONEO(int n_IDONEO) {
		N_IDONEO = n_IDONEO;
	}


	public String getOBSERVACIONES() {
		return OBSERVACIONES;
	}


	public void setOBSERVACIONES(String oBSERVACIONES) {
		OBSERVACIONES = oBSERVACIONES;
	}


	public int getID_ESTADO() {
		return ID_ESTADO;
	}


	public void setID_ESTADO(int iD_ESTADO) {
		ID_ESTADO = iD_ESTADO;
	}



}
