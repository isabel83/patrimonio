package com.patrimonio.plantillas.client.widgets.forms;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.utils.LoadInformesUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormInformes extends ContentPanel{
	LoadInformesUtils utils = new LoadInformesUtils();

	int panelActivo = 0;
	
	String[] titulos={"Informes > Pedidos", "Informes > Solicitudes de material", "Informes > Artículos", "Informes > Proveedores", "Informes > Puestos de trabajo", "Informes > Previsión de vestuario"};
	
	public FormInformes(int posicion) {
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
		
		GWT.setUncaughtExceptionHandler(new   
			      GWT.UncaughtExceptionHandler() {  
			      public void onUncaughtException(Throwable e) {  
			       // Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			  });    
		
		FormPanel form = new FormPanel();
		form.setHeaderVisible(false);
		form.setExpanded(true);
		form.setAutoHeight(true);
		form.setBodyBorder(false);
		form.setBorders(false);
		loadInformes(form, panelActivo);
		add(form);
		
	}
	
	
	private void loadInformes(FormPanel form, int activo) {
		switch(activo){
		case 0: utils.loadPedidos(form); break;
		case 1: utils.loadSolicitudes(form); break;
		case 2: utils.loadArticulos(form); break;
		case 3: utils.loadProveedores(form); break;
		case 4: utils.loadPuestos(form); break;
		case 5: final TextField<String> anio = new TextField<String>();  
				anio.setStyleAttribute("margin", "10px 2px 10px 2px");
				anio.setWidth("272px");
				Dialog anyo = new Dialog();
				anyo.setHideOnButtonClick(true);
				anyo.setHeading("Introduce el año sobre el que quieres realizar la consulta de previsión");
				anyo.setButtons(Dialog.OKCANCEL);
				anyo.setModal(true);
				anyo.getButtonById(Dialog.OK).addSelectionListener(new SelectionListener<ButtonEvent>(){
		
					@Override
					public void componentSelected(ButtonEvent ce) {
						//Aqui iria el generar informe
					}
					
				});
				anyo.add(anio, new BorderLayoutData(LayoutRegion.CENTER));
				anyo.show();
				}
		
	}

}