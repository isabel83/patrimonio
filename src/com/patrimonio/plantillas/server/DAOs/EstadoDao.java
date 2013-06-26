package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.patrimonio.plantillas.server.HibernateUtils;
import com.patrimonio.plantillas.shared.clases.Estado;

public class EstadoDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Estado findById(Long id) { 
		Estado estado = null;
        try {
            estado = (Estado) sessionFactory.getCurrentSession().get(Estado.class, id);
            Hibernate.initialize(estado);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return estado;
		
	}
	

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Estado> getEstados(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Estado");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Estado> sublist = (ArrayList<Estado>) query.list();
		return new BasePagingLoadResult<Estado>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveEstado(Estado estado) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(estado); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateEstado(Estado estado) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(estado); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeEstado(List<Estado> estados) {

		sessionFactory.getCurrentSession().beginTransaction();
		  for (Estado es : estados) {
			  getSessionFactory().getCurrentSession().delete(es); 
		  }
		  sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
