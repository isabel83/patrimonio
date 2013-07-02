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
import com.patrimonio.plantillas.shared.clases.Destinatario;

public class DestinatarioDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Destinatario findById(Long des) { 
		sesion = sessionFactory.openSession();
		Destinatario dest = null;
        try {
            dest = (Destinatario) sesion.get(Destinatario.class, des);
            Hibernate.initialize(dest);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return dest;
		
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Destinatario> getDestinatarios(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Destinatario");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Destinatario> sublist = (ArrayList<Destinatario>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Destinatario>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveDestinatario(Destinatario destinatario) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(destinatario); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateDestinatario(Destinatario destinatario) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(destinatario); 
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
	
	public boolean removeDestinatario(Destinatario destinatario) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(destinatario); 
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
