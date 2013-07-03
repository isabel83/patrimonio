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
import com.patrimonio.plantillas.shared.clases.Perfiles;

public class PerfilesDao   extends HibernateDaoSupport{
	
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Perfiles findById(Long id) { 
		sesion = sessionFactory.openSession();
		Perfiles perfil = null;
        try {
            perfil = (Perfiles) sesion.get(Perfiles.class, id);
            Hibernate.initialize(perfil);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return perfil;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Perfiles> getPerfiles(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Perfiles");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Perfiles> sublist = (ArrayList<Perfiles>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Perfiles>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePerfil(Perfiles perfil) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(perfil); 
			sesion.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion = sessionFactory.openSession();
		}
		 
	}

	public boolean updatePerfil(Perfiles perfil) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(perfil); 
			sesion.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally {
			sesion.close();
		}
		
	}
	
	public boolean removePerfil(List<Perfiles> Perfiles) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (Perfiles per : Perfiles) {
				getSessionFactory().getCurrentSession().delete(per); 
			}
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
