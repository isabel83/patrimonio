package com.patrimonio.plantillas.client.DTOs;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;


public class PerfilDTO extends BaseModel implements Serializable{

	private Long id;
	private int administrador;
	private int validador;
	private int usuario;
	private int operario;
	
	public PerfilDTO(){
		
	}
	
	public PerfilDTO(long id, int admin, int val, int usr, int op){
		set("id", id);
		set("administrador", administrador);
		set("validador", validador);
		set("usuario", usuario);
		set("operario", operario);
		this.id=id;
		this.administrador=admin;
		this.validador=val;
		this.usuario=usr;
		this.operario=op;
	}
	
	public Long getId_perfil() {
		try {
			return get("id");
		} catch (Exception e) {
			return this.id;
		}
	}
	
	public void setId_perfil(Long id_perfil) {
		this.id = id_perfil;
	}
	
	public int getAdministrador() {
		try {
			return get("administrador");
		} catch (Exception e) {
			return this.administrador;
		}
	}
	
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	
	public int getValidador() {
		try {
			return get("validador");
		} catch (Exception e) {
			return this.validador;
		}
	}
	
	public void setValidador(int validador) {
		this.validador = validador;
	}
	
	public int getUsuario() {
		try {
			return get("usuario");
		} catch (Exception e) {
			return this.usuario;
		}
	}
	
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public int getOperario() {
		try {
			return get("operario");
		} catch (Exception e) {
			return this.operario;
		}
	}
	
	public void setOperario(int operario) {
		this.operario = operario;
	}
}
