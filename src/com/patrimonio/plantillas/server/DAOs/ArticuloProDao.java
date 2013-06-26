package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	public PagingLoadResult<ArticuloPro> getArticulos(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from ArticuloDTO");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<ArticuloPro> sublist = (ArrayList<ArticuloPro>) query.list();
		return new BasePagingLoadResult<ArticuloPro>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveArticulo(ArticuloPro articulo) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(articulo); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateArticulo(ArticuloPro articulo) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(articulo); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeArticulo(List<ArticuloPro> articulos) {

		sessionFactory.getCurrentSession().beginTransaction();
		  for (ArticuloPro art : articulos) {
			  getSessionFactory().getCurrentSession().delete(art); 
		  }
		  sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
