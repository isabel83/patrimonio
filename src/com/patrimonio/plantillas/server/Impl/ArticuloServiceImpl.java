package com.patrimonio.plantillas.server.Impl;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.patrimonio.plantillas.server.DAOs.ArticulosDao;
import com.patrimonio.plantillas.shared.clases.Articulos;
import com.patrimonio.plantillas.shared.clases.Arti_Prov;
import com.patrimonio.plantillas.client.services.ArticuloService;


public class ArticuloServiceImpl extends RemoteServiceServlet implements ArticuloService{

	public ArticulosDao articuloDAO;

	
	@Override
	public Articulos findArticulo(long idArticulo) {
		return articuloDAO.findById(idArticulo);

	}

	@Override
	public void saveArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
		  Articulos articulo = articuloDAO.findById(idArticulo);
		  if(articulo == null) {
			  articulo = new Articulos(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
			 articuloDAO.saveArticulo(articulo);
		  }
		
	}

	@Override
	public void updateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observaciones, int estado)
			throws Exception {
		Articulos articulo = articuloDAO.findById(idArticulo); 
		   
		  if(articulo != null) { 
			   articulo.setId_seccion(seccion);
			   articulo.setId_familia(familia);
			   articulo.setId_subfamilia(subFamilia);
			   articulo.setCodigo(codigo);
			   articulo.setNombre(nombre);
			   articulo.setMarca(marca);
			   articulo.setN_minimo(numMin);
			   articulo.setN_idoneo(numIdeal);
			   articulo.setObservaciones(observaciones);
			   articulo.setId_estado(estado);
			   articuloDAO.updateArticulo(articulo);
		  } 
		
	}

	@Override
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
		Articulos articulo = new Articulos(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
		articuloDAO.updateArticulo(articulo);
	
	}

	@Override
	public void deleteArticulo(long idArticulo) throws Exception {
		
		Articulos articulo = articuloDAO.findById(idArticulo);
		if(articulo!=null)
			articuloDAO.removeArticulo(articulo);
	}

	@Override
	public List<Articulos> loadArticulosPro(int idProveedor) {
		List<Articulos> lstArticulos = null;
		List<Arti_Prov> todos = articuloDAO.findArtProveedor(idProveedor);
		for(Arti_Prov art: todos){
			lstArticulos.add(articuloDAO.findById(Long.parseLong(String.valueOf(art.getID_ARTICULO()))));
		}
		return lstArticulos;
	}
	

}
