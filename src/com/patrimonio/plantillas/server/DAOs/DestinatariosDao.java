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
import com.patrimonio.plantillas.shared.clases.Destinatarios;
import com.patrimonio.plantillas.shared.clases.Proveedores;

public class DestinatariosDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Destinatarios findById(Long des) { 
		sesion = sessionFactory.openSession();
		Destinatarios dest = null;
        try {
            dest = (Destinatarios) sesion.get(Destinatarios.class, des);
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
	public PagingLoadResult<Destinatarios> getDestinatarios(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Destinatarios");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Destinatarios> sublist = (ArrayList<Destinatarios>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Destinatarios>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveDestinatario(Destinatarios destinatario) {
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

	public boolean updateDestinatario(Destinatarios destinatario) {

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
	
	public boolean removeDestinatario(Destinatarios destinatario) {

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

	@Transactional
	public long getMaxId() { 
		long valor = 0;
		sesion = sessionFactory.openSession();
		try{
			Query query =  sesion.createQuery("select max(id) as max from Destinatarios");
			
			List sublist = query.list();
			if(sublist.get(0)!=null)
				valor = (Long) sublist.get(0);
	
			return valor;
		}
		catch(Exception e){
			return valor;
		}
		finally{
			sesion.close();
		}
	}

	public List<Destinatarios> findAll() {
		sesion = sessionFactory.openSession();
		
		List<Destinatarios> todos = sesion.createQuery("from Destinatarios").list();
		sesion.close();
		return todos;
	}

}
