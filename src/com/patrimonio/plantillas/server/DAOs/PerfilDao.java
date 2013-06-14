package com.patrimonio.plantillas.server.DAOs;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrimonio.plantillas.shared.DTOs.PerfilDTO;

public class PerfilDao extends JpaDao<Long, PerfilDTO>{
	@Autowired
	 EntityManagerFactory entityManagerFactory;

	 @PostConstruct
	 public void init() {
	  super.setEntityManagerFactory(entityManagerFactory);
	 }

}
