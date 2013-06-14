package com.patrimonio.plantillas.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;

public interface ArticuloServiceAsync {

	void findArticulo(long idArticulo, AsyncCallback<ArticuloDTO> callback);

	void deleteArticulo(long idArticulo, AsyncCallback<Void> callback);

	void saveArticulo(long idArticulo, int seccion, int familia,
			int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observacion, int estado,
			AsyncCallback<Void> callback);

	void saveOrUpdateArticulo(long idArticulo, int seccion, int familia,
			int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observacion, int estado,
			AsyncCallback<Void> callback);

	void updateArticulo(long idArticulo, int seccion, int familia,
			int subFamilia, int codigo, String nombre, String marca,
			int numMin, int numIdeal, String observacion, int estado,
			AsyncCallback<Void> callback);

}
