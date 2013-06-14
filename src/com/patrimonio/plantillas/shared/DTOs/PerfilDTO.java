package com.patrimonio.plantillas.shared.DTOs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERFILES")
public class PerfilDTO implements Serializable{

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
	
	public PerfilDTO(){
		
	}
	
	public PerfilDTO(long id, int admin, int val, int usr, int op){
		this.id=id;
		this.administrador=admin;
		this.validador=val;
		this.usuario=usr;
		this.operario=op;
	}
	
	public Long getId_perfil() {
		return id;
	}
	
	public void setId_perfil(Long id_perfil) {
		this.id = id_perfil;
	}
	
	public int getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	
	public int getValidador() {
		return validador;
	}
	
	public void setValidador(int validador) {
		this.validador = validador;
	}
	
	public int getUsuario() {
		return usuario;
	}
	
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public int getOperario() {
		return operario;
	}
	
	public void setOperario(int operario) {
		this.operario = operario;
	}
}
