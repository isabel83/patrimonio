package com.patrimonio.plantillas.server.DAOs;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.patrimonio.plantillas.shared.DTOs.FamiliaDTO;

public class FamiliaDao extends JpaDao<Long, FamiliaDTO>{
	@Autowired
	 EntityManagerFactory entityManagerFactory;

	 @PostConstruct
	 public void init() {
	  super.setEntityManagerFactory(entityManagerFactory);
	 }

}
