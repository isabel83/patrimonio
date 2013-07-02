package com.patrimonio.plantillas.shared.clases;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.patrimonio.plantillas.client.DTOs.PerfilDTO;


@Entity
@Table(name = "PERFILES")
public class Perfil extends BaseModel implements Serializable{

	@GeneratedValue
	@Id
	@Column(name="ID_PERFIL")
	private Long id;
	
	@Column(name="ADMINISTRADOR")
	private int administrador;
	
	@Column(name="VALIDADOR")
	private int validador;

	@Column(name="USUARIO")
	private int usuario;

	@Column(name="OPERARIO")
	private int operario;
	
	public Perfil(){
		
	}
	
	public Perfil(long id, int admin, int val, int usr, int op){
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
	
	public Perfil(PerfilDTO perfil){
		this.id=perfil.getId_perfil();
		this.administrador=perfil.getAdministrador();
		this.validador=perfil.getValidador();
		this.usuario=perfil.getUsuario();
		this.operario=perfil.getOperario();
	}
	
	public Long getId_perfil() {
		return this.id;
	}
	
	public void setId_perfil(Long id_perfil) {
		this.id = id_perfil;
	}
	
	public int getAdministrador() {
		return this.administrador;
	}
	
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	
	public int getValidador() {
		return this.validador;
	}
	
	public void setValidador(int validador) {
		this.validador = validador;
	}
	
	public int getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public int getOperario() {
		return this.operario;
	}
	
	public void setOperario(int operario) {
		this.operario = operario;
	}
}
