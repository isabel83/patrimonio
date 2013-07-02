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
import com.patrimonio.plantillas.shared.clases.Familia;

public class FamiliaDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Familia findById(Long id) {
		sesion = sessionFactory.openSession();
		Familia familia = null;
        try {
            familia = (Familia) sesion.get(Familia.class, id);
            Hibernate.initialize(familia);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return familia;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Familia> getFamilias(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Familia");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Familia> sublist = (ArrayList<Familia>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Familia>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveFamilia(Familia familia) {
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

	public boolean updateFamilia(Familia familia) {

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
	
	public boolean removeFamilia(Familia familia) {
		
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
