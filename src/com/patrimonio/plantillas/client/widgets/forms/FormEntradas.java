package com.patrimonio.plantillas.client.widgets.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;

import com.patrimonio.plantillas.client.utils.LoadEntradasUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormEntradas extends ContentPanel{

	LoadEntradasUtils utils = new LoadEntradasUtils();

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
		
		GWT.setUncaughtExceptionHandler(new   
			      GWT.UncaughtExceptionHandler() {  
			      public void onUncaughtException(Throwable e) {  
			        //Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			    
			  });    
		
		FormPanel form = new FormPanel();
		form.setHeaderVisible(false);
		form.setExpanded(true);
		form.setAutoHeight(true);
		form.setBodyBorder(false);
		form.setBorders(false);
		loadEntradas(form, panelActivo);
		add(form);
	}
	
	
	private void loadEntradas(FormPanel form, int activo) {
		switch(activo) {
			case 0: utils.loadFormNuevoPedido(form); break;
			case 1: utils.loadFormRecepcion(form);break;
			case 2: utils.loadFormNuevoArticulo(form);break;
			case 3: utils.loadFormArticuloEliminado(form);break;
		}
	}


}
