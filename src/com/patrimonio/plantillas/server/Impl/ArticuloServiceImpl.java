package com.patrimonio.plantillas.server.Impl;

import com.patrimonio.plantillas.server.DAOs.ArticuloDao;
import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;
import com.patrimonio.plantillas.shared.services.ArticuloService;

public class ArticuloServiceImpl implements ArticuloService{

	public ArticuloDao articuloDAO;
	
	@Override
	public ArticuloDTO findArticulo(long idArticulo) {
		return articuloDAO.findById(idArticulo);

	}

	@Override
	public void saveArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
		  ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo);
		  if(articuloDTO == null) {
			  articuloDTO = new ArticuloDTO(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
			  articuloDAO.persist(articuloDTO);
		  }
		
	}

	@Override
	public void updateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observaciones, int estado)
			throws Exception {
		ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo); 
		   
		  if(articuloDTO != null) { 
		   articuloDTO.setId_seccion(seccion);
		   articuloDTO.setId_familia(familia);
		   articuloDTO.setId_subfamilia(subFamilia);
		   articuloDTO.setCodigo(codigo);
		   articuloDTO.setNombre(nombre);
		   articuloDTO.setMarca(marca);
		   articuloDTO.setN_minimo(numMin);
		   articuloDTO.setN_idoneo(numIdeal);
		   articuloDTO.setObservaciones(observaciones);
		   articuloDTO.setId_estado(estado);
		  } 
		
	}

	@Override
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
		ArticuloDTO articuloDTO = new ArticuloDTO(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
		articuloDAO.merge(articuloDTO);
	
	}

	@Override
	public void deleteArticulo(long idArticulo) throws Exception {
		
		ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo);
		 
		if(articuloDTO != null) {
			articuloDAO.remove(articuloDTO);
		}
	}

}
