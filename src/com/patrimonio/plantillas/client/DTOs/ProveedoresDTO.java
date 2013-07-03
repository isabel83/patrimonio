package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;


import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.shared.clases.Proveedores;


public class ProveedoresDTO extends BaseModel implements Serializable{
	

	private Long ID_PROVEEDOR;

	private String NIF;

    private String NOMBRE;

    private String ACTIVIDAD;

    private String CONTACTO;

    private String DOMICILIO;

    private String POBLACION;

    private int CP;

    private String PROVINCIA;

    private String TLF1;

    private String TLF2;

    private int MOVIL;

    private String FAX;

    private String EMAIL;

    private int ID_ESTADO;
    
	public ProveedoresDTO(){
		
	}
	
	public ProveedoresDTO(long id){
		set("id", id);
		this.ID_PROVEEDOR=id;
	}
	
	public ProveedoresDTO(long id, String nif, String nombre){
		set("id", id);
		set("nif", nif);
		set("nombre", nombre);
		this.ID_PROVEEDOR=id;
		this.NIF=nif;
		this.NOMBRE=nombre;
	}
	
	public ProveedoresDTO(long id, String nif, String nombre, String actividad, String contacto, String direccion, String poblacion, int cp, String provincia, String tf1, String tf2, int mvl, String fax, String mail, int estado){
		set("id", id);
		set("nif", nif);
		set("nombre", nombre);
		set("actividad", actividad);
		set("contacto", contacto);
		set("direccion", direccion);
		set("poblacion", poblacion);
		set("cp", cp);
		set("provincia", provincia);
		set("tel1", TLF1);
		set("tel2", TLF2);
		set("mvl", mvl);
		set("fax", fax);
		set("mail", mail);
		set("estado", estado);
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
    
	public Long getId_proveedor() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.ID_PROVEEDOR;
		}
	}
	
	public void setId_proveedor(Long id_proveedor) {
		this.ID_PROVEEDOR = id_proveedor;
	}
	
	public String getNif() {
		try {
			return get("nif");
		} catch (Exception e) {
			return this.NIF;
		}
	}
	public void setNif(String nif) {
		this.NIF = nif;
	}
	
	public String getNombre() {
		try {
			return get("nombre");
		} catch (Exception e) {
			return this.NOMBRE;
		}
	}
	
	public void setNombre(String nombre) {
		this.NOMBRE = nombre;
	}
	
	public String getActividad() {
		try {
			return get("actividad");
		} catch (Exception e) {
			return this.ACTIVIDAD;
		}
	}
	
	public void setActividad(String actividad) {
		this.ACTIVIDAD = actividad;
	}
	
	public String getContacto() {
		try {
			return get("contacto");
		} catch (Exception e) {
			return this.CONTACTO;
		}
	}
	
	public void setContacto(String contacto) {
		this.CONTACTO = contacto;
	}
	
	public String getDomicilio() {
		try {
			return get("direccion");
		} catch (Exception e) {
			return this.DOMICILIO;
		}
	}
	
	public void setDomicilio(String domicilio) {
		this.DOMICILIO = domicilio;
	}
	
	public String getPoblacion() {
		try {
			return get("poblacion");
		} catch (Exception e) {
			return this.POBLACION;
		}
	}
	
	public void setPoblacion(String poblacion) {
		this.POBLACION = poblacion;
	}
	
	public int getCp() {
		try {
			return get("cp");
		} catch (Exception e) {
			return this.CP;
		}
	}
	
	public void setCp(int cp) {
		this.CP = cp;
	}
	
	public String getProvincia() {
		try {
			return get("provincia");
		} catch (Exception e) {
			return this.PROVINCIA;
		}
	}
	
	public void setProvincia(String provincia) {
		this.PROVINCIA = provincia;
	}
	
	public String getTlf1() {
		try {
			return get("tel1");
		} catch (Exception e) {
			return this.TLF1;
		}
	}
	
	public void setTlf1(String tlf1) {
		this.TLF1 = tlf1;
	}
	
	public String getTlf2() {
		try {
			return get("tel2");
		} catch (Exception e) {
			return this.TLF2;
		}
	}
	
	public void setTlf2(String tlf2) {
		this.TLF2 = tlf2;
	}
	
	public int getMovil() {
		try {
			return get("mvl");
		} catch (Exception e) {
			return this.MOVIL;
		}
	}
	
	public void setMovil(int movil) {
		this.MOVIL = movil;
	}
	
	public String getFax() {
		try {
			return get("fax");
		} catch (Exception e) {
			return this.FAX;
		}
	}
	
	public void setFax(String fax) {
		this.FAX = fax;
	}
	
	public String getEmail() {
		try {
			return get("mail");
		} catch (Exception e) {
			return this.EMAIL;
		}
	}
	
	public void setEmail(String email) {
		this.EMAIL = email;
	}
	
	public int getId_estado() {
		try {
			return get("estado");
		} catch (Exception e) {
			return this.ID_ESTADO;
		}
	}
	
	public void setId_estado(int id_estado) {
		this.ID_ESTADO = id_estado;
	}
}
