package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ProveedoresDTO;


public class Proveedores extends BaseModel implements Serializable{
	
	private Long ID_PROVEEDOR;

	private String NIF;

    private String NOMBRE;

    private String ACTIVIDAD; //no requerido

    private String CONTACTO; //no requerido

    private String DOMICILIO; //no requerido

    private String POBLACION; //no requerido

    private int CP; //no requerido

    private String PROVINCIA; //no requerido

    private String TLF1; //no requerido

    private String TLF2; //no requerido

    private int MOVIL; //no requerido

    private String FAX; //no requerido

    private String EMAIL; //no requerido

    private int ID_ESTADO;
    
	public Proveedores(){
		
	}
	
	
	
	public Proveedores(String nif, String nombre){
		this.NIF=nif;
		this.NOMBRE=nombre;
	}
	
	public Proveedores(String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
		this.NIF=nif;
		this.NOMBRE=nombre;
		this.ACTIVIDAD=actividad;
		this.CONTACTO=contacto;
		this.DOMICILIO=direccion;
		this.POBLACION=poblacion;
		this.CP=cp;
		this.PROVINCIA=provincia;
		this.TLF1=tf1;
		this.TLF2=tf2;
		this.MOVIL=mvl;
		this.FAX=fax;
		this.EMAIL=mail;
		this.ID_ESTADO=estado;
	}
	
	public Proveedores (ProveedoresDTO proveedor){
		this.NIF=proveedor.getNif();
		this.NOMBRE=proveedor.getNombre();
		this.ACTIVIDAD=proveedor.getActividad();
		this.CONTACTO=proveedor.getContacto();
		this.DOMICILIO=proveedor.getDomicilio();
		this.POBLACION=proveedor.getPoblacion();
		this.CP=proveedor.getCp();
		this.PROVINCIA=proveedor.getProvincia();
		this.TLF1=proveedor.getTlf1();
		this.TLF2=proveedor.getTlf2();
		this.MOVIL=proveedor.getMovil();
		this.FAX=proveedor.getFax();
		this.EMAIL=proveedor.getEmail();
		this.ID_ESTADO=proveedor.getId_estado();
	}
	
	public Long getId_proveedor() {
			return this.ID_PROVEEDOR;
	}
	
	public void setId_proveedor(Long id_proveedor) {
		this.ID_PROVEEDOR = id_proveedor;
	}
	
	public String getNif() {
			return this.NIF;
	}
	public void setNif(String nif) {
		this.NIF = nif;
	}
	
	public String getNombre() {
			return this.NOMBRE;
	}
	
	public void setNombre(String nombre) {
		this.NOMBRE = nombre;
	}
	
	public String getActividad() {
			return this.ACTIVIDAD;
	}
	
	public void setActividad(String actividad) {
		this.ACTIVIDAD = actividad;
	}
	
	public String getContacto() {
		return this.CONTACTO;
	}
	
	public void setContacto(String contacto) {
		this.CONTACTO = contacto;
	}
	
	public String getDomicilio() {
			return this.DOMICILIO;
	}
	
	public void setDomicilio(String domicilio) {
		this.DOMICILIO = domicilio;
	}
	
	public String getPoblacion() {
			return this.POBLACION;
	}
	
	public void setPoblacion(String poblacion) {
		this.POBLACION = poblacion;
	}
	
	public int getCp() {
			return this.CP;
	}
	
	public void setCp(int cp) {
		this.CP = cp;
	}
	
	public String getProvincia() {
			return this.PROVINCIA;
	}
	
	public void setProvincia(String provincia) {
		this.PROVINCIA = provincia;
	}
	
	public String getTlf1() {
			return this.TLF1;
	}
	
	public void setTlf1(String tlf1) {
		this.TLF1 = tlf1;
	}
	
	public String getTlf2() {
			return this.TLF2;
	}
	
	public void setTlf2(String tlf2) {
		this.TLF2 = tlf2;
	}
	
	public int getMovil() {
			return this.MOVIL;
	}
	
	public void setMovil(int movil) {
		this.MOVIL = movil;
	}
	
	public String getFax() {
			return this.FAX;
	}
	
	public void setFax(String fax) {
		this.FAX = fax;
	}
	
	public String getEmail() {
			return this.EMAIL;
	}
	
	public void setEmail(String email) {
		this.EMAIL = email;
	}
	
	public int getId_estado() {
			return this.ID_ESTADO;
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
}
