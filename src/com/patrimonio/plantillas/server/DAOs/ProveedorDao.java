package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.patrimonio.plantillas.server.HibernateUtils;
import com.patrimonio.plantillas.shared.clases.Proveedor;

@Repository
public class ProveedorDao  extends HibernateDaoSupport{
	
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Proveedor> findAll(){
		sesion = sessionFactory.openSession();
		
		List<Proveedor> todos = sesion.createQuery("from Proveedor").list();
		sesion.close();
		return todos;
	}
	
	@Transactional
	public Proveedor findById(Long id) { 
		sesion = sessionFactory.openSession();
		Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) sesion.get(Proveedor.class, id);
            Hibernate.initialize(proveedor);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }

        return proveedor;
		
	}
	

	@SuppressWarnings("unchecked")
	@Transactional
	public PagingLoadResult<Proveedor> getProveedores(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from Proveedor");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Proveedor> sublist = (ArrayList<Proveedor>) query.list();
		sessionFactory.getCurrentSession().close();
		return new BasePagingLoadResult<Proveedor>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveProveedor(Proveedor proveedor) {
		sesion = sessionFactory.openSession();
		Transaction t = sesion.beginTransaction();
		try {
			sesion.save(proveedor); 
			t.commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	@Transactional
	public boolean updateProveedor(Proveedor proveedor) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(proveedor); 
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
	public boolean removeProveedor(Proveedor proveedor) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(proveedor); 
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
			Query query =  sesion.createQuery("select max(id) as max from Proveedor");
			
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


}

