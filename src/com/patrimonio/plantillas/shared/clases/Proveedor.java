package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.ProveedorDTO;


@Entity
@Table(name = "PROVEEDORES")
public class Proveedor extends BaseModel implements Serializable{
	
	@GeneratedValue
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
    
	public Proveedor(){
		
	}
	
	public Proveedor(long id){
		set("id", id);
		this.id=id;
	}
	
	public Proveedor(long id, String nif, String nombre){
		set("id", id);
		set("nif", nif);
		set("nombre", nombre);
		this.id=id;
		this.nif=nif;
		this.nombre=nombre;
	}
	
	public Proveedor(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
		set("id", id);
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
	
	public Proveedor (ProveedorDTO proveedor){
		this.id=proveedor.getId_proveedor();
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
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_proveedor(Long id_proveedor) {
		this.id = id_proveedor;
	}
	
	public String getNif() {
		try {
			return get("nif");
		} catch (Exception e) {
			return this.nif;
		}
	}
	public void setNif(String nif) {
		this.nif = nif;
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
	
	public String getActividad() {
		try {
			return get("actividad");
		} catch (Exception e) {
			return this.actividad;
		}
	}
	
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	public String getContacto() {
		try {
			return get("contacto");
		} catch (Exception e) {
			return this.contacto;
		}
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	public String getDomicilio() {
		try {
			return get("direccion");
		} catch (Exception e) {
			return this.direccion;
		}
	}
	
	public void setDomicilio(String domicilio) {
		this.direccion = domicilio;
	}
	
	public String getPoblacion() {
		try {
			return get("poblacion");
		} catch (Exception e) {
			return this.poblacion;
		}
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public int getCp() {
		try {
			return get("cp");
		} catch (Exception e) {
			return this.cp;
		}
	}
	
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	public String getProvincia() {
		try {
			return get("provincia");
		} catch (Exception e) {
			return this.provincia;
		}
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getTlf1() {
		try {
			return get("tel1");
		} catch (Exception e) {
			return this.tel1;
		}
	}
	
	public void setTlf1(String tlf1) {
		this.tel1 = tlf1;
	}
	
	public String getTlf2() {
		try {
			return get("tel2");
		} catch (Exception e) {
			return this.tel2;
		}
	}
	
	public void setTlf2(String tlf2) {
		this.tel2 = tlf2;
	}
	
	public int getMovil() {
		try {
			return get("mvl");
		} catch (Exception e) {
			return this.mvl;
		}
	}
	
	public void setMovil(int movil) {
		this.mvl = movil;
	}
	
	public String getFax() {
		try {
			return get("fax");
		} catch (Exception e) {
			return this.fax;
		}
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		try {
			return get("mail");
		} catch (Exception e) {
			return this.mail;
		}
	}
	
	public void setEmail(String email) {
		this.mail = email;
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
