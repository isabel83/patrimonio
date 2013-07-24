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
import com.patrimonio.plantillas.shared.clases.Proveedores;

@Repository
public class ProveedoresDao  extends HibernateDaoSupport{
	
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Proveedores> findAll(){
		sesion = sessionFactory.openSession();
		
		List<Proveedores> todos = sesion.createQuery("from Proveedores").list();
		sesion.close();
		return todos;
	}
	
	@Transactional
	public Proveedores findById(Long id) { 
		sesion = sessionFactory.openSession();
		Proveedores proveedor = null;
        try {
            proveedor = (Proveedores) sesion.get(Proveedores.class, id);
            Hibernate.initialize(proveedor);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        finally{
        	sesion.close();
        }

        return proveedor;
		
	}
	

	@Transactional
	public PagingLoadResult<Proveedores> getProveedores(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		try{
			Query query =  sesion.createQuery("from Proveedores");
			Integer cuantos=query.list().size();
			query.setFirstResult(loadConfig.getOffset());
			query.setMaxResults(loadConfig.getLimit());
			ArrayList<Proveedores> sublist = (ArrayList<Proveedores>) query.list();
			return new BasePagingLoadResult<Proveedores>(sublist, loadConfig.getOffset(),cuantos);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			sesion.close();
		}
		
	}
	
	@Transactional
	public boolean saveProveedor(Proveedores proveedor) {
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
	public boolean updateProveedor(Proveedores proveedor) {
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
	public boolean removeProveedor(Proveedores proveedor) {
		proveedor.setId_estado(0);
		return updateProveedor(proveedor);
		
	}

}

