package com.patrimonio.plantillas.server.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.patrimonio.plantillas.server.HibernateUtils;
import com.patrimonio.plantillas.shared.clases.Articulos;
import com.patrimonio.plantillas.shared.clases.Arti_Prov;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public class ArticulosDao extends HibernateDaoSupport{
	@Autowired
	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	Session sesion;
	
	private int idSeccion;
	private int idFamilia;
	private int idSubFamilia;
	private int codigo;
	private String nombre;
	private String marca;
	private int minimo;
	private int idoneo;
	private String observ;
	
	@SuppressWarnings("unchecked")
	public List<Arti_Prov> findArtProveedor(int idProveedor) {
		sesion = sessionFactory.openSession();
		//CON HIBERNATE SACO DATOS
		List<Arti_Prov> results = sesion.createCriteria(Arti_Prov.class)
		.add(Restrictions.eq("id_proveedor", idProveedor))
		.addOrder(Property.forName("id_articulo").asc())
		.list();
		
		sesion.close();
		
		//devolvemos todas las relaciones de articulos del proveedor dado
		return results;
	}

	public Articulos findById(Long id) { 
		sesion = sessionFactory.openSession();
		Articulos art=null;
        try {
            art = (Articulos) sesion.get(Articulos.class, id);
            Hibernate.initialize(art);
        } catch (Exception e) {
            e.printStackTrace();
        }  
        finally{
        	sesion.close();
        }
        return art;
		
	}
	
	@SuppressWarnings("unchecked")
	public PagingLoadResult<Articulos> getArticulos(PagingLoadConfig loadConfig){
		sesion = sessionFactory.openSession();
		Query query =  sesion.createQuery("from Articulos");
		Integer cuantos=query.list().size();
		query.setFirstResult(loadConfig.getOffset());
		query.setMaxResults(loadConfig.getLimit());
		ArrayList<Articulos> sublist = (ArrayList<Articulos>) query.list();
		sesion.close();
		return new BasePagingLoadResult<Articulos>(sublist, loadConfig.getOffset(),cuantos);
	}
	
	@Transactional
	public boolean saveArticulo(Articulos articulo) {
		sesion = sessionFactory.openSession();
		try {
			sesion.beginTransaction();
			sesion.save(articulo); 
			sesion.getTransaction().commit();
		
			  return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			sesion.close();
		}
		 
	}

	public boolean updateArticulo(Articulos articulo) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.update(articulo); 
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
	
	public boolean removeArticulo(Articulos articulo) {
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			sesion.delete(articulo); 
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

	public List<Articulos> findByCriterios(Articulos articuloBusqueda) {
		
		cargaDatos(articuloBusqueda);
		
		List<Articulos> resultado = null;
		sesion = sessionFactory.openSession();
		try{
			sesion.beginTransaction();
			Criteria cr = sesion.createCriteria(Articulos.class);
			if(idSeccion!=0) cr.add(Restrictions.eq("ID_SECCION", idSeccion));
			if(idFamilia!=0) cr.add(Restrictions.eq("ID_FAMILIA", idFamilia));
			if(idSubFamilia!=0) cr.add(Restrictions.eq("ID_SUBFAMILIA", idSubFamilia));
			if(codigo!=0) cr.add(Restrictions.eq("CODIGO", codigo));
			if(nombre!=null) cr.add(Restrictions.eq("NOMBRE", nombre));
			if(marca!=null) cr.add(Restrictions.eq("MARCA", marca));
			if(minimo!=0) cr.add(Restrictions.eq("N_MINIMO", minimo));
			if(idoneo!=0) cr.add(Restrictions.eq("N_IDONEO", idoneo));
			if(observ!=null) cr.add(Restrictions.eq("OBSERVACIONES", observ));
			cr.add(Restrictions.eq("ID_ESTADO", 0));
			resultado = cr.list();
			sesion.getTransaction().commit();
		}
		catch(Exception e){
			return null;
		}
		finally{
			sesion.close();
		}
		return resultado;
	}

	private void cargaDatos(Articulos articuloBusqueda) {
		idSeccion=articuloBusqueda.getId_seccion();
		idFamilia=articuloBusqueda.getId_familia();
		idSubFamilia=articuloBusqueda.getId_subfamilia();
		codigo=articuloBusqueda.getCodigo();
		nombre=articuloBusqueda.getNombre();
		marca=articuloBusqueda.getMarca();
		minimo=articuloBusqueda.getN_minimo();
		idoneo=articuloBusqueda.getN_idoneo();
		observ=articuloBusqueda.getObservaciones();
	}

	public List<Articulos> findAll() {
		sesion = sessionFactory.openSession();
		
		List<Articulos> todos = sesion.createQuery("from Articulos").list();
		sesion.close();
		return todos;
	}
	

}
