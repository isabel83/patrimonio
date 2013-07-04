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
import com.patrimonio.plantillas.shared.clases.Familias;
import com.patrimonio.plantillas.shared.clases.Secciones;

public class FamiliasDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Familias findById(Long id) {
		sesion = sessionFactory.openSession();
		Familias familia = null;
        try {
            familia = (Familias) sesion.get(Familias.class, id);
            Hibernate.initialize(familia);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return familia;
		
	}
	
	public List<Familias> findAll() {
		sesion = sessionFactory.openSession();
		
		List<Familias> todos = sesion.createQuery("from Familias").list();
		sesion.close();
		return todos;
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Familias> getFamilias(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Familias");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Familias> sublist = (ArrayList<Familias>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Familias>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveFamilia(Familias familia) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(familia); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateFamilia(Familias familia) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(familia); 
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
	
	public boolean removeFamilia(Familias familia) {
		
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(familia); 
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
