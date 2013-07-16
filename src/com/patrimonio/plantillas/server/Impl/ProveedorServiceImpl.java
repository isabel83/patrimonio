package com.patrimonio.plantillas.server.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.client.DTOs.ProveedoresDTO;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.server.DAOs.ProveedoresDao;
import com.patrimonio.plantillas.shared.clases.Proveedores;


@Service
public class ProveedorServiceImpl extends RemoteServiceServlet implements ProveedorService{

	private ProveedoresDao proveedorDao = new ProveedoresDao();
	
	
	public PagingLoadResult<Proveedores> findAll(PagingLoadConfig config){
		return proveedorDao.getProveedores(config);
	}

	public Proveedores findProveedor(long idProveedor) {
		return proveedorDao.findById(idProveedor);
	}
	
	public void saveProveedor(Proveedores proveedor) throws Exception{
		proveedorDao.saveProveedor(proveedor);
	}

	public void saveProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {

		Proveedores proveedor = proveedorDao.findById(id);
		if(proveedor==null){
			proveedor = new Proveedores(nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
			proveedorDao.saveProveedor(proveedor);
		}
		
	}

	public void updateProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		
		Proveedores proveedor = proveedorDao.findById(id);
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
			proveedorDao.updateProveedor(proveedor);
		}
	}

	public void saveOrUpdateProveedor(String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		Proveedores proveedor = new Proveedores(nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
		proveedorDao.updateProveedor(proveedor);
	}

	public void deleteProveedor(long idProveedor) throws Exception {
		
		Proveedores proveedor = proveedorDao.findById(idProveedor);
		if(proveedor!=null)
			proveedorDao.removeProveedor(proveedor);
	}

	public List<Proveedores> findAllForList() throws Exception {
		return proveedorDao.findAll();
	}

	private ProveedoresDTO createProDTO(Proveedores pro) {
		return new ProveedoresDTO(pro.getId_proveedor(), pro.getNif(), pro.getNombre());
	}

}
