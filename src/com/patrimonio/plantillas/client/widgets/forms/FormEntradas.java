package com.patrimonio.plantillas.client.widgets.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormEntradas extends ContentPanel{


	int panelActivo = 0;
	
	String[] titulos={"Entradas > Nuevo pedido", "Entradas > Recepción de pedidos", "Entradas > Nuevo artículo", "Entradas > Recuperar artículo eliminado"};
	
	public FormEntradas(int numPanel) {
		panelActivo = numPanel;
	}


	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);

		setLayout(new BorderLayout());
		setBodyBorder(false);
		setBorders(false);
		setHeading(titulos[panelActivo]);
		getHeader().setStyleName("cabecera");
		setStyleName("migas");
		setWidth(1024);
		setAutoHeight(true);
		add(new MenuIconos());
		
		GWT.setUncaughtExceptionHandler(new   
			      GWT.UncaughtExceptionHandler() {  
			      public void onUncaughtException(Throwable e) {  
			        //Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			    
			  });    
		
		switch(panelActivo){
			case 0:add(new NuevoPedido());break;
			case 1:add(new Recepcion());break;
			case 2:add(new NuevoArticulo());break;
			case 3:add(new ArticuloEliminado());break;
		}

	}
	
	

}
