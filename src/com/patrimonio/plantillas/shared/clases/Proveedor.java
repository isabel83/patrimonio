package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ProveedorDTO;


@Entity
@Table(name = "PROVEEDORES")
public class Proveedor extends BaseModel implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID_PROVEEDOR", nullable=false)
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
    
	public Proveedor(){
		
	}
	
	
	
	public Proveedor(String nif, String nombre){
		set("nif", nif);
		set("nombre", nombre);
		this.nif=nif;
		this.nombre=nombre;
	}
	
	public Proveedor(String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
		set("nif", nif);
		set("nombre", nombre);
		set("actividad", actividad);
		set("contacto", contacto);
		set("direccion", direccion);
		set("poblacion", poblacion);
		set("cp", cp);
		set("provincia", provincia);
		set("tel1", tel1);
		set("tel2", tel2);
		set("mvl", mvl);
		set("fax", fax);
		set("mail", mail);
		set("estado", estado);
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
	
	public Proveedor (ProveedorDTO proveedor){
		/*set("id", proveedor.getId_proveedor());
		set("nif", proveedor.getNif());
		set("nombre", proveedor.getNombre());
		set("actividad", proveedor.getActividad());
		set("contacto", proveedor.getContacto());
		set("direccion", proveedor.getDomicilio());
		set("poblacion", proveedor.getPoblacion());
		set("cp", proveedor.getCp());
		set("provincia", proveedor.getProvincia());
		set("tel1", proveedor.getTlf1());
		set("tel2", proveedor.getTlf2());
		set("mvl", proveedor.getMovil());
		set("fax", proveedor.getFax());
		set("mail", proveedor.getEmail());
		set("estado", proveedor.getId_estado());*/
		this.nif=proveedor.getNif();
		this.nombre=proveedor.getNombre();
		this.actividad=proveedor.getActividad();
		this.contacto=proveedor.getContacto();
		this.direccion=proveedor.getDomicilio();
		this.poblacion=proveedor.getPoblacion();
		this.cp=proveedor.getCp();
		this.provincia=proveedor.getProvincia();
		this.tel1=proveedor.getTlf1();
		this.tel2=proveedor.getTlf2();
		this.mvl=proveedor.getMovil();
		this.fax=proveedor.getFax();
		this.mail=proveedor.getEmail();
		this.estado=proveedor.getId_estado();
	}
	
	public Long getId_proveedor() {
			return this.id;
	}
	
//	public void setId_proveedor(Long id_proveedor) {
//		this.id = id_proveedor;
//	}
	
	public String getNif() {
			return this.nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getNombre() {
			return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getActividad() {
			return this.actividad;
	}
	
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	public String getContacto() {
		return this.contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getDomicilio() {
			return this.direccion;
	}
	
	public void setDomicilio(String domicilio) {
		this.direccion = domicilio;
	}
	
	public String getPoblacion() {
			return this.poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public int getCp() {
			return this.cp;
	}
	
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public String getProvincia() {
			return this.provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getTlf1() {
			return this.tel1;
	}
	
	public void setTlf1(String tlf1) {
		this.tel1 = tlf1;
	}
	
	public String getTlf2() {
			return this.tel2;
	}
	
	public void setTlf2(String tlf2) {
		this.tel2 = tlf2;
	}
	
	public int getMovil() {
			return this.mvl;
	}
	
	public void setMovil(int movil) {
		this.mvl = movil;
	}
	
	public String getFax() {
			return this.fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
			return this.mail;
	}
	
	public void setEmail(String email) {
		this.mail = email;
	}
	
	public int getId_estado() {
			return this.estado;
	}
	
	public void setId_estado(int id_estado) {
		this.estado = id_estado;
	}
}
