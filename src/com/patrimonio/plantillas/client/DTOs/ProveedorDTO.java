package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;


public class ProveedorDTO extends BaseModel implements Serializable{
	

	private Long id;
	private String nif;
    private String nombre;
    private String actividad;
    private String contacto;
    private String direccion;
    private String poblacion;
    private int cp;
    private String provincia;
    private String tel1;
    private String tel2;
    private int mvl;
    private String fax;
    private String mail;
    private int estado;
    
	public ProveedorDTO(){
		
	}
	
	public ProveedorDTO(long id){
		set("id", id);
		this.id=id;
	}
	
	public ProveedorDTO(long id, String nif, String nombre){
		set("id", id);
		set("nif", nif);
		set("nombre", nombre);
		this.id=id;
		this.nif=nif;
		this.nombre=nombre;
	}
	
	public ProveedorDTO(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
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
