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
import com.patrimonio.plantillas.shared.clases.Puestos;

public class PuestosDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;

	public Puestos findById(Long id) { 
		sesion = sessionFactory.openSession();
		Puestos puesto = null;
        try {
            puesto = (Puestos) sesion.get(Puestos.class, id);
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
	public PagingLoadResult<Puestos> getPuestos(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Puestos");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Puestos> sublist = (ArrayList<Puestos>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Puestos>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePuesto(Puestos puesto) {
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

	public boolean updatePuesto(Puestos puesto) {
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
	
	public boolean removePuesto(Puestos puesto) {

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

