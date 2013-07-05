package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

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
import com.patrimonio.plantillas.shared.clases.Destinatarios;
import com.patrimonio.plantillas.shared.clases.Personas;

public class PersonasDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Personas findById(Long id) {
		sesion = sessionFactory.openSession();
		Personas persona = null;
        try {
            persona = (Personas) sesion.get(Personas.class, id);
            Hibernate.initialize(persona);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return persona;
		
	}
	
	public List<Personas> findAll() {
		sesion = sessionFactory.openSession();
		
		List<Personas> todos = sesion.createQuery("from Personas").list();
		sesion.close();
		return todos;
	}
	

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Personas> getPersonas(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Personas");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Personas> sublist = (ArrayList<Personas>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Personas>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePersona(Personas persona) {
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

	public boolean updatePersona(Personas persona) {

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
	
	public boolean removePersona(Personas persona) {

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
