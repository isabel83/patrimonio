package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.patrimonio.plantillas.server.HibernateUtils;
import com.patrimonio.plantillas.shared.clases.Articulo;
import com.patrimonio.plantillas.shared.clases.ArticuloPro;

public class ArticuloDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	@SuppressWarnings("unchecked")
	public List<ArticuloPro> findArtProveedor(int idProveedor) {
		//CON HIBERNATE SACO DATOS
		List<ArticuloPro> results = sessionFactory.getCurrentSession().createCriteria(ArticuloPro.class)
		.add(Restrictions.eq("proveedor", idProveedor))
		.addOrder(Property.forName("articulo").asc())
		.list();
		
		//devolvemos todas las relaciones de articulos del proveedor dado
		return results;
	}

	public Articulo findById(Long id) { 
		Articulo art=null;
        try {
            art = (Articulo) sessionFactory.getCurrentSession().get(Articulo.class, id);
            Hibernate.initialize(art);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return art;
		
	}
	
	@SuppressWarnings("unchecked")
	public PagingLoadResult<Articulo> getArticulos(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Articulo");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Articulo> sublist = (ArrayList<Articulo>) query.list();
		return new BasePagingLoadResult<Articulo>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveArticulo(Articulo articulo) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(articulo); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateArticulo(Articulo articulo) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(articulo); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeArticulo(Articulo articulo) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(articulo); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	

}
