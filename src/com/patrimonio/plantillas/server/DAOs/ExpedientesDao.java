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
import com.patrimonio.plantillas.shared.clases.Expedientes;

public class ExpedientesDao   extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Expedientes findById(Long id) {
		sesion = sessionFactory.openSession();
		Expedientes expediente = null;
        try {
            expediente = (Expedientes) sesion.get(Expedientes.class, id);
            Hibernate.initialize(expediente);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return expediente;
		
	}
	

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Expedientes> getExpedientes(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Expedientes");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Expedientes> sublist = (ArrayList<Expedientes>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Expedientes>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveExpediente(Expedientes expediente) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(expediente); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateExpediente(Expedientes expediente) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(expediente); 
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
	
	public boolean removeExpediente(List<Expedientes> expedientes) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (Expedientes ex : expedientes) {
				getSessionFactory().getCurrentSession().delete(ex); 
			}
			sesion.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally{
			sesion = sessionFactory.openSession();
		}
	}

}

