package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	Session sesion = sessionFactory.openSession();

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Proveedor> findAll(){
		return sesion.createQuery("from Proveedor").list();
	}
	
	@Transactional
	public Proveedor findById(Long id) { 
		Proveedor proveedor = null;
        try {
            proveedor = (Proveedor) sesion.get(Proveedor.class, id);
            Hibernate.initialize(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return proveedor;
		
	}
	

	@SuppressWarnings("unchecked")
	@Transactional
	public PagingLoadResult<Proveedor> getProveedores(PagingLoadConfig loadConfig){
		Query query =  sessionFactory.openSession().createQuery("from ProveedorDTO");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Proveedor> sublist = (ArrayList<Proveedor>) query.list();
		return new BasePagingLoadResult<Proveedor>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveProveedor(Proveedor proveedor) {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().save(proveedor); 
			sessionFactory.getCurrentSession().getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		 
	}

	@Transactional
	public boolean updateProveedor(Proveedor proveedor) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().update(proveedor); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}
	
	@Transactional
	public boolean removeProveedor(Proveedor proveedor) {

		sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().delete(proveedor); 
		sessionFactory.getCurrentSession().getTransaction().commit();
	
		  return true;
	}


}

