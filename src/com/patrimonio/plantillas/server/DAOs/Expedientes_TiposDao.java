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
import com.patrimonio.plantillas.shared.clases.Expedientes_Tipos;

public class Expedientes_TiposDao   extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Expedientes_Tipos findById(Long id) {
		sesion = sessionFactory.openSession();
		Expedientes_Tipos e_Tipo = null;
        try {
        	e_Tipo = (Expedientes_Tipos) sesion.get(Expedientes_Tipos.class, id);
            Hibernate.initialize(e_Tipo);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return e_Tipo;
		
	}
	

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Expedientes_Tipos> getExpedientes_Tipos(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Expedientes_Tipos");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Expedientes_Tipos> sublist = (ArrayList<Expedientes_Tipos>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Expedientes_Tipos>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveExpedientes_Tipo(Expedientes_Tipos expediente_Tipo) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(expediente_Tipo); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateExpedientes_Tipo(Expedientes_Tipos expediente_Tipo) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(expediente_Tipo); 
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
	
	public boolean removeExpedientes_Tipo(List<Expedientes_Tipos> expedientes_Tipos) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (Expedientes_Tipos ex : expedientes_Tipos) {
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

