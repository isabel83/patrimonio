package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
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
import com.patrimonio.plantillas.shared.clases.Puesto;

public class PuestoDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	public Puesto findById(Long id) { 
		Puesto puesto = null;
        try {
            puesto = (Puesto) sessionFactory.getCurrentSession().get(Puesto.class, id);
            Hibernate.initialize(puesto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return puesto;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public PagingLoadResult<Puesto> getPuestos(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Puesto");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Puesto> sublist = (ArrayList<Puesto>) query.list();
		return new BasePagingLoadResult<Puesto>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePuesto(Puesto puesto) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(puesto); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updatePuesto(Puesto puesto) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(puesto); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removePuesto(Puesto puesto) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(puesto); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}

