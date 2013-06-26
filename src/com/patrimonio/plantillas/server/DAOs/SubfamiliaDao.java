package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;

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
import com.patrimonio.plantillas.shared.clases.Subfamilia;

public class SubfamiliaDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Subfamilia findById(Long id) { 
		Subfamilia sub = null;
        try {
            sub = (Subfamilia) sessionFactory.getCurrentSession().get(Subfamilia.class, id);
            Hibernate.initialize(sub);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return sub;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Subfamilia> getSubfamilias(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Subfamilia");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Subfamilia> sublist = (ArrayList<Subfamilia>) query.list();
		return new BasePagingLoadResult<Subfamilia>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveSubfamilia(Subfamilia subfamilia) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(subfamilia); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateSubfamilia(Subfamilia subfamilia) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(subfamilia); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeSubfamilia(Subfamilia subfamilia) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(subfamilia); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	    return true;
	}

}
