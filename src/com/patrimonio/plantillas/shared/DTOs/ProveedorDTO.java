package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PROVEEDORES")
public class ProveedorDTO implements Serializable{
	
	@Id
	@Column(name="ID_PROVEEDOR")
	private Long id;

	@Column(name="NIF")
	private String nif;

	@Column(name="NOMBRE")
    private String nombre;

	@Column(name="ACTIVIDAD")
    private String actividad;

	@Column(name="CONTACTO")
    private String contacto;

	@Column(name="DOMICILIO")
    private String direccion;

	@Column(name="POBLACION")
    private String poblacion;

	@Column(name="CP")
    private int cp;

	@Column(name="PROVINCIA")
    private String provincia;

	@Column(name="TLF1")
    private String tel1;

	@Column(name="TLF2")
    private String tel2;

	@Column(name="MOVIL")
    private int mvl;

	@Column(name="FAX")
    private String fax;

	@Column(name="EMAIL")
    private String mail;

	@Column(name="ID_ESTADO")
    private int estado;
    
	public ProveedorDTO(){
		
	}
	
	public ProveedorDTO(long id){
		this.id=id;
	}
	
	public ProveedorDTO(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
		this.id=id;
		this.nif=nif;
		this.nombre=nombre;
		this.actividad=actividad;
		this.contacto=contacto;
		this.direccion=direccion;
		this.poblacion=poblacion;
		this.cp=cp;
		this.provincia=provincia;
		this.tel1=tf1;
		this.tel2=tf2;
		this.mvl=mvl;
		this.fax=fax;
		this.mail=mail;
		this.estado=estado;
	}
    
	public Long getId_proveedor() {
		return id;
	}
	
	public void setId_proveedor(Long id_proveedor) {
		this.id = id_proveedor;
	}
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getActividad() {
		return actividad;
	}
	
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getDomicilio() {
		return direccion;
	}
	
	public void setDomicilio(String domicilio) {
		this.direccion = domicilio;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public int getCp() {
		return cp;
	}
	
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getTlf1() {
		return tel1;
	}
	
	public void setTlf1(String tlf1) {
		this.tel1 = tlf1;
	}
	
	public String getTlf2() {
		return tel2;
	}
	
	public void setTlf2(String tlf2) {
		this.tel2 = tlf2;
	}
	
	public int getMovil() {
		return mvl;
	}
	
	public void setMovil(int movil) {
		this.mvl = movil;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return mail;
	}
	
	public void setEmail(String email) {
		this.mail = email;
	}
	
	public int getId_estado() {
		return estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
}
