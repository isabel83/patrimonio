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
import com.patrimonio.plantillas.shared.clases.Puesto;

public class PuestoDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;

	public Puesto findById(Long id) { 
		sesion = sessionFactory.openSession();
		Puesto puesto = null;
        try {
            puesto = (Puesto) sesion.get(Puesto.class, id);
            Hibernate.initialize(puesto);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return puesto;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public PagingLoadResult<Puesto> getPuestos(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Puesto");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Puesto> sublist = (ArrayList<Puesto>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Puesto>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePuesto(Puesto puesto) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(puesto); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updatePuesto(Puesto puesto) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(puesto); 
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
	
	public boolean removePuesto(Puesto puesto) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(puesto); 
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

