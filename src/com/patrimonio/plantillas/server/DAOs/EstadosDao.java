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
import com.patrimonio.plantillas.shared.clases.Estados;

public class EstadosDao  extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	public Estados findById(Long id) {
		sesion = sessionFactory.openSession();
		Estados estado = null;
        try {
            estado = (Estados) sesion.get(Estados.class, id);
            Hibernate.initialize(estado);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }
        return estado;
		
	}
	

	@SuppressWarnings("unchecked")
	public PagingLoadResult<Estados> getEstados(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Estados");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Estados> sublist = (ArrayList<Estados>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Estados>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveEstado(Estados estado) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(estado); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateEstado(Estados estado) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(estado); 
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
	
	public boolean removeEstado(List<Estados> estados) {

		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			for (Estados es : estados) {
				getSessionFactory().getCurrentSession().delete(es); 
			}
			sesion.getTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally{
			sesion = sessionFactory.openSession();
		}
	}

}
