package com.patrimonio.plantillas.client.design;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Stock extends BaseModel {

  /**
	 * 
	 */
	private static final long serialVersionUID = 8380899723206492609L;

public Stock() {
  }

  public Stock(int cantidad, String codigo, String articulo, String observaciones) {
    set("cantidad", cantidad);
    set("codigo", codigo);
    set("articulo", articulo);
    set("observaciones", observaciones);

  }



  public int getCantidad() {
    return get("cantidad");
  }

  
  
  public String getCodigo() {
    return (String) get("codigo");
  }

  public String getArticulo() {
    return (String) get("articulo");
  }

  public String getObservaciones() {
    return (String) get("observaciones");
  }

  
}