package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Articulos;


@RemoteServiceRelativePath("articulos")
public interface ArticuloService extends RemoteService{
	
	public Articulos findArticulo (long idArticulo);
	public void saveArticulo(Articulos articulo) throws Exception;
	public void updateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void deleteArticulo(long idArticulo) throws Exception;
	public List<Articulos> loadArticulosPro(int idProveedor);
	public List<Articulos> findByCriterios(Articulos articuloBusqueda) throws Exception;
	public List<Articulos> findAllForList() throws Exception;
}
