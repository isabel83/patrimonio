package com.patrimonio.plantillas.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.shared.clases.Articulo;


@RemoteServiceRelativePath("articulos")
public interface ArticuloService extends RemoteService{
	
	public Articulo findArticulo (long idArticulo);
	public void saveArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void updateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void deleteArticulo(long idArticulo) throws Exception;
	public List<Articulo> loadArticulosPro(int idProveedor);

}
