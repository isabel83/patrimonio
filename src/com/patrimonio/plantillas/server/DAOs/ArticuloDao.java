package com.patrimonio.plantillas.server.DAOs;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;
import com.patrimonio.plantillas.shared.DTOs.ArticuloProDTO;

public class ArticuloDao   extends HibernateDaoSupport{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session sesion;
	
	public List<ArticuloProDTO> findArtProveedor(int idProveedor) {
		//CON HIBERNATE SACO DATOS
		List<ArticuloProDTO> results = sesion.createCriteria(ArticuloProDTO.class)
		.add(Restrictions.eq("proveedor", idProveedor))
		.addOrder(Property.forName("articulo").asc())
		.list();
		
		//devolvemos todas las relaciones de articulos del proveedor dado
		return results;
	}

	public List<ArticuloDTO> findById(Long articulo) { 
		List<ArticuloDTO> result = sesion.createCriteria(ArticuloDTO.class)
		.add( Restrictions.like("id", articulo) )
		.list();
		
		return result;
		
	}

}
