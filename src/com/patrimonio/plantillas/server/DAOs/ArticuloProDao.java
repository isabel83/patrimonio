package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.patrimonio.plantillas.server.HibernateUtils;
import com.patrimonio.plantillas.shared.clases.ArticuloPro;

public class ArticuloProDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;

	@SuppressWarnings("unchecked")
	public PagingLoadResult<ArticuloPro> getArticulos(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Articulo");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<ArticuloPro> sublist = (ArrayList<ArticuloPro>) query.list();
		sesion.close();
		return new BasePagingLoadResult<ArticuloPro>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveArticulo(ArticuloPro articulo) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(articulo); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 finally{
			 sesion.close();
		 }
	}

	public boolean updateArticulo(ArticuloPro articulo) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(articulo); 
			sesion.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally{
			sesion.close();
		}
	  
	}
	
	public boolean removeArticulo(List<ArticuloPro> articulos) {
		
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (ArticuloPro art : articulos) {
				getSessionFactory().getCurrentSession().delete(art); 
			}
			sesion.getTransaction().commit();
	
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally{
			sesion.close();
		}
	}

}
