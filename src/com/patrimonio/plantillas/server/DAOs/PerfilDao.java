package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
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
	
	public Perfil findById(Long id) { 
		Perfil perfil = null;
        try {
            perfil = (Perfil) sessionFactory.getCurrentSession().get(Perfil.class, id);
            Hibernate.initialize(perfil);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return perfil;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Perfil> getPerfiles(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Perfil");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Perfil> sublist = (ArrayList<Perfil>) query.list();
		return new BasePagingLoadResult<Perfil>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean savePerfil(Perfil perfil) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(perfil); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updatePerfil(Perfil perfil) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(perfil); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removePerfil(List<Perfil> Perfiles) {

		sessionFactory.getCurrentSession().beginTransaction();
		  for (Perfil per : Perfiles) {
			  getSessionFactory().getCurrentSession().delete(per); 
		  }
		  sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
