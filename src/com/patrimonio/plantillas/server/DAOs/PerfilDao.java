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
import com.patrimonio.plantillas.shared.clases.Perfil;

public class PerfilDao   extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Perfil findById(Long id) { 
		sesion = sessionFactory.openSession();
		Perfil perfil = null;
        try {
            perfil = (Perfil) sesion.get(Perfil.class, id);
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
	public PagingLoadResult<Perfil> getPerfiles(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Perfil");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Perfil> sublist = (ArrayList<Perfil>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Perfil>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePerfil(Perfil perfil) {
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

	public boolean updatePerfil(Perfil perfil) {

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
	
	public boolean removePerfil(List<Perfil> Perfiles) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (Perfil per : Perfiles) {
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
