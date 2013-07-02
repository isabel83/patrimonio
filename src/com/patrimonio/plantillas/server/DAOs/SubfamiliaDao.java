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
import com.patrimonio.plantillas.shared.clases.Subfamilia;

public class SubfamiliaDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Subfamilia findById(Long id) { 
		sesion = sessionFactory.openSession();
		Subfamilia sub = null;
        try {
            sub = (Subfamilia) sesion.get(Subfamilia.class, id);
            Hibernate.initialize(sub);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return sub;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Subfamilia> getSubfamilias(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Subfamilia");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Subfamilia> sublist = (ArrayList<Subfamilia>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Subfamilia>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveSubfamilia(Subfamilia subfamilia) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(subfamilia); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 finally{
			 sesion.close();
		 }
	}

	public boolean updateSubfamilia(Subfamilia subfamilia) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(subfamilia); 
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
	
	public boolean removeSubfamilia(Subfamilia subfamilia) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(subfamilia); 
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
