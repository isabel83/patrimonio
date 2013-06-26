package com.patrimonio.plantillas.server.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.client.DTOs.ProveedorDTO;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.server.DAOs.ProveedorDao;
import com.patrimonio.plantillas.shared.clases.Proveedor;

public class ProveedorServiceImpl extends RemoteServiceServlet implements ProveedorService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	private ProveedorDao sessionFactory = (ProveedorDao) context.getBean("proveedorDao",ProveedorDao.class);
	
	public PagingLoadResult<Proveedor> findAll(PagingLoadConfig config){
		return sessionFactory.getProveedores(config);
	}

	public Proveedor findProveedor(long idProveedor) {
		return sessionFactory.findById(idProveedor);
	}

	public void saveProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {

		Proveedor proveedor = sessionFactory.findById(id);
		if(proveedor==null){
			proveedor = new Proveedor(id,nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
			sessionFactory.saveProveedor(proveedor);
		}
		
		
	}

	public void updateProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		
		Proveedor proveedor = sessionFactory.findById(id);
		if(proveedor!=null){
			proveedor.setNif(nif);
			proveedor.setNombre(nombre);
			proveedor.setActividad(actividad);
			proveedor.setContacto(contacto);
			proveedor.setDomicilio(direccion);
			proveedor.setPoblacion(poblacion);
			proveedor.setCp(cp);
			proveedor.setProvincia(provincia);
			proveedor.setTlf1(tf1);
			proveedor.setTlf2(tf2);
			proveedor.setMovil(mvl);
			proveedor.setFax(fax);
			proveedor.setEmail(mail);
			proveedor.setId_estado(estado);
			sessionFactory.updateProveedor(proveedor);
		}
	}

	public void saveOrUpdateProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		
		Proveedor proveedor = new Proveedor(id,nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
		sessionFactory.updateProveedor(proveedor);
		
	}

	public void deleteProveedor(long idProveedor) throws Exception {
		
		Proveedor proveedor = sessionFactory.findById(idProveedor);
		if(proveedor!=null)
			sessionFactory.removeProveedor(proveedor);
	}

	public List<ProveedorDTO> findAllForList() throws Exception {
		System.out.println("Estoy en la funcion del servicio");
		List<Proveedor> result = sessionFactory.findAll();
		List<ProveedorDTO> proveedores = new ArrayList<ProveedorDTO>(result != null ? result.size() : 0);;
		for(Proveedor pro: result){
			proveedores.add(createProDTO(pro));
		}
		return proveedores;
		
	}

	private ProveedorDTO createProDTO(Proveedor pro) {
		return new ProveedorDTO(pro.getId_proveedor(), pro.getNif(), pro.getNombre());
	}

}
