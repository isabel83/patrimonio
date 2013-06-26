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
import com.patrimonio.plantillas.shared.clases.Destinatario;

public class DestinatarioDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	
	public Destinatario findById(Long des) { 
		Destinatario dest = null;
        try {
            dest = (Destinatario) sessionFactory.getCurrentSession().get(Destinatario.class, des);
            Hibernate.initialize(dest);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return dest;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Destinatario> getDestinatarios(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Destinatario");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Destinatario> sublist = (ArrayList<Destinatario>) query.list();
		return new BasePagingLoadResult<Destinatario>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveDestinatario(Destinatario destinatario) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(destinatario); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	public boolean updateDestinatario(Destinatario destinatario) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(destinatario); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	public boolean removeDestinatario(Destinatario destinatario) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(destinatario); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}

}
