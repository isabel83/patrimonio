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
import com.patrimonio.plantillas.shared.clases.Seccion;

public class SeccionDao   extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Seccion findById(Long id) { 
		Seccion seccion = null;
		sesion = sessionFactory.openSession();
        try {
            seccion = (Seccion) sesion.get(Seccion.class, id);
            Hibernate.initialize(seccion);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return seccion;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Seccion> getSecciones(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Seccion");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Seccion> sublist = (ArrayList<Seccion>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Seccion>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveSeccion(Seccion seccion) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(seccion); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateSeccion(Seccion seccion) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(seccion); 
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
	
	public boolean removeSeccion(Seccion seccion) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(seccion); 
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
