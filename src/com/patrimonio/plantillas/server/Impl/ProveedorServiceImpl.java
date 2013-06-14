package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.ProveedorDao;
import com.patrimonio.plantillas.shared.DTOs.ProveedorDTO;
import com.patrimonio.plantillas.shared.services.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService{

	public ProveedorDao proveedorDao;
	
	@Override
	public ProveedorDTO findProveedor(long idProveedor) {
		
		return proveedorDao.findById(idProveedor);
	}

	@Override
	public void saveProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		ProveedorDTO proveedorDto = proveedorDao.findById(id);
		if(proveedorDto==null){
			proveedorDto = new ProveedorDTO(id,nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
			proveedorDao.persist(proveedorDto);
		}
		
		
	}

	@Override
	public void updateProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		
		ProveedorDTO proveedorDto = proveedorDao.findById(id);
		if(proveedorDto!=null){
			proveedorDto.setNif(nif);
			proveedorDto.setNombre(nombre);
			proveedorDto.setActividad(actividad);
			proveedorDto.setContacto(contacto);
			proveedorDto.setDomicilio(direccion);
			proveedorDto.setPoblacion(poblacion);
			proveedorDto.setCp(cp);
			proveedorDto.setProvincia(provincia);
			proveedorDto.setTlf1(tf1);
			proveedorDto.setTlf2(tf2);
			proveedorDto.setMovil(mvl);
			proveedorDto.setFax(fax);
			proveedorDto.setEmail(mail);
			proveedorDto.setId_estado(estado);
		}
	}

	@Override
	public void saveOrUpdateProveedor(long id, String nif, String nombre,
			String actividad, String contacto, String direccion,
			String poblacion, int cp, String provincia, String tf1, String tf2,
			int mvl, String fax, String mail, int estado) throws Exception {
		
		ProveedorDTO proveedorDto = new ProveedorDTO(id,nif,nombre,actividad,contacto,direccion,poblacion,cp,provincia,tf1,tf2,mvl,fax,mail,estado);
		proveedorDao.merge(proveedorDto);
		
	}

	@Override
	public void deleteProveedor(long idProveedor) throws Exception {
		
		ProveedorDTO proveedorDto = proveedorDao.findById(idProveedor);
		if(proveedorDto!=null)
			proveedorDao.remove(proveedorDto);
	}

}
