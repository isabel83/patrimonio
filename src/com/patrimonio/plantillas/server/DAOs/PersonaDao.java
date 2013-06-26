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
import com.patrimonio.plantillas.shared.clases.Persona;

public class PersonaDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Persona findById(Long id) { 
		Persona persona = null;
        try {
            persona = (Persona) sessionFactory.getCurrentSession().get(Persona.class, id);
            Hibernate.initialize(persona);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return persona;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Persona> getPersonas(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Persona");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Persona> sublist = (ArrayList<Persona>) query.list();
		return new BasePagingLoadResult<Persona>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePersona(Persona persona) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(persona); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updatePersona(Persona persona) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(persona); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removePersona(Persona persona) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(persona); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
