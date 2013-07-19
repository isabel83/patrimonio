package com.patrimonio.plantillas.client.widgets.forms;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.utils.LoadSalidasUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormSalidas extends ContentPanel{

	LoadSalidasUtils utils = new LoadSalidasUtils();

	int panelActivo = 0;
	
	String[] titulos={"Salidas > Nueva solicitud", "Salidas > Control de entregas", "Salidas > Baja de artículos"};
	
	public FormSalidas(int posicion) {
		panelActivo = posicion;
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
			    // do module loading stuff  
			  });    
		
		FormPanel form = new FormPanel();
		form.setHeaderVisible(false);
		form.setExpanded(true);
		form.setAutoHeight(true);
		form.setBodyBorder(false);
		form.setBorders(false);
		loadSalidas(form, panelActivo);
		add(form);
		
	}
	
	
	private void loadSalidas(FormPanel form, int activo) {
		switch(activo){
			case 0: utils.loadFormNuevaSolicitud(form); break;
			case 1: utils.loadFormAlbaranes(form); break;
			case 2: utils.loadFormBajaArticulo(form); break;
		}
		
	}

}
