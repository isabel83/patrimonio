package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;

public interface ArticuloService extends RemoteService{
	
	public ArticuloDTO findArticulo (long idArticulo);
	public void saveArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void updateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia, int subFamilia, int codigo, String nombre, String marca, int numMin, int numIdeal, String observacion, int estado) throws Exception;
	public void deleteArticulo(long idArticulo) throws Exception;

}
