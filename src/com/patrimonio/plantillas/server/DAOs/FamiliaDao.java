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
import com.patrimonio.plantillas.shared.clases.Familia;

public class FamiliaDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Familia findById(Long id) { 
		Familia familia = null;
        try {
            familia = (Familia) sessionFactory.getCurrentSession().get(Familia.class, id);
            Hibernate.initialize(familia);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return familia;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Familia> getFamilias(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Familia");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Familia> sublist = (ArrayList<Familia>) query.list();
		return new BasePagingLoadResult<Familia>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveFamilia(Familia familia) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(familia); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateFamilia(Familia familia) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(familia); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeFamilia(Familia familia) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(familia); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
