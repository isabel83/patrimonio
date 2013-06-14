package com.patrimonio.plantillas.server.DAOs;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrimonio.plantillas.shared.DTOs.EstadoDTO;

public class EstadoDao extends JpaDao<Long, EstadoDTO>{
	@Autowired
	 EntityManagerFactory entityManagerFactory;

	 @PostConstruct
	 public void init() {
	  super.setEntityManagerFactory(entityManagerFactory);
	 }

}
