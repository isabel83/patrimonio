package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;

import org.hibernate.Hibernate;
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
import com.patrimonio.plantillas.shared.clases.Persona;

public class PersonaDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Persona findById(Long id) {
		sesion = sessionFactory.openSession();
		Persona persona = null;
        try {
            persona = (Persona) sesion.get(Persona.class, id);
            Hibernate.initialize(persona);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return persona;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Persona> getPersonas(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Persona");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Persona> sublist = (ArrayList<Persona>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Persona>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePersona(Persona persona) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(persona); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updatePersona(Persona persona) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(persona); 
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
	
	public boolean removePersona(Persona persona) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(persona); 
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
