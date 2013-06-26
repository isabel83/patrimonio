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
import com.patrimonio.plantillas.shared.clases.Seccion;

public class SeccionDao   extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Seccion findById(Long id) { 
		Seccion seccion = null;
        try {
            seccion = (Seccion) sessionFactory.getCurrentSession().get(Seccion.class, id);
            Hibernate.initialize(seccion);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return seccion;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Seccion> getSecciones(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Seccion");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Seccion> sublist = (ArrayList<Seccion>) query.list();
		return new BasePagingLoadResult<Seccion>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveSeccion(Seccion seccion) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(seccion); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateSeccion(Seccion seccion) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(seccion); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeSeccion(Seccion seccion) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(seccion); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
