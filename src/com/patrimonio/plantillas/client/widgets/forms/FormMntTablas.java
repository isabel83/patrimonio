package com.patrimonio.plantillas.client.widgets.forms;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.utils.LoadMantenimientoUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormMntTablas extends ContentPanel{
	LoadMantenimientoUtils utils = new LoadMantenimientoUtils();

	int panelActivo = 0;
	
	String[] titulos={"Mantenimiento de tablas > Proveedores", "Mantenimiento de tablas > Destinatarios", "Mantenimiento de tablas > Secciones", "Mantenimiento de tablas > Familias", "Mantenimiento de tablas > Subfamilias", "Mantenimiento de tablas > Puestos de trabajo"};
	
	public FormMntTablas(int posicion) {
		panelActivo = posicion;
	}

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);
		Log.debug("EL ON RENDER");
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
			        Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			  });    
		
		FormPanel form = new FormPanel();
		form.setHeaderVisible(false);
		form.setExpanded(true);
		form.setAutoHeight(true);
		form.setBodyBorder(false);
		form.setBorders(false);
		loadMantenimientos(form, panelActivo);
		add(form);
		
			
	} 
	
	
	private void loadMantenimientos(FormPanel form, int activo) {
		switch(activo){
			case 0: utils.loadFormProveedores(form); break;
			case 1: utils.loadFormDestinatarios(form); break; 
			case 2: utils.loadFormSecciones(form);break;
			case 3: utils.loadFormFamilias(form);break;
			case 4: utils.loadFormSubFamilias(form);break;
			case 5: utils.loadFormPuestos(form);break;
		}
	}

}
