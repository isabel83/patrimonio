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

	@Override
	protected void onLoad() {
		
		super.onLoad();

		recalculate();
	}
	

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);

		setLayout(new BorderLayout());
		setBodyBorder(false);
		setBorders(false);
		setHeaderVisible(false);
		setSize(1024, 768);
		
		GWT.setUncaughtExceptionHandler(new   
			      GWT.UncaughtExceptionHandler() {  
			      public void onUncaughtException(Throwable e) {  
			       // Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			  });    
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadInformes(tabPanel);
		
		add(tabPanel);
		
	}
	
	
	private void loadInformes(TabPanel panel) {
		
		FormPanel frmPedidos = new FormPanel();
		frmPedidos.setHeaderVisible(false);
		frmPedidos.setAutoHeight(true);
		utils.loadPedidos(frmPedidos);
		
		TabItem tabPedidos = new TabItem("Pedidos");
		tabPedidos.add(new MenuIconos());
		tabPedidos.add(frmPedidos);
		panel.add(tabPedidos);
		
		FormPanel frmSolicitudes = new FormPanel();
		frmSolicitudes.setHeaderVisible(false);
		frmSolicitudes.setAutoHeight(true);
		utils.loadSolicitudes(frmSolicitudes);
		
		TabItem tabSolicitudes = new TabItem("Solicitudes de Material");
		tabSolicitudes.add(new MenuIconos());
		tabSolicitudes.add(frmSolicitudes);
		panel.add(tabSolicitudes);
		
		FormPanel frmArticulos = new FormPanel();
		frmArticulos.setHeaderVisible(false);
		frmArticulos.setAutoHeight(true);
		utils.loadArticulos(frmArticulos);
		
		
		TabItem tabArticulos = new TabItem("Articulos");
		tabArticulos.add(new MenuIconos());
		tabArticulos.add(frmArticulos);
		panel.add(tabArticulos);
		
		FormPanel frmProveedores = new FormPanel();
		frmProveedores.setHeaderVisible(false);
		frmProveedores.setAutoHeight(true);
		utils.loadProveedores(frmProveedores);
		
		
		TabItem tabProveedores = new TabItem("Proveedores");
		tabProveedores.add(new MenuIconos());
		tabProveedores.add(frmProveedores);
		panel.add(tabProveedores);
		
		FormPanel frmPuestos = new FormPanel();
		frmPuestos.setHeaderVisible(false);
		frmPuestos.setAutoHeight(true);
		utils.loadPuestos(frmPuestos);
		
		
		TabItem tabPuestos = new TabItem("Puestos de trabajo");
		tabPuestos.add(new MenuIconos());
		tabPuestos.add(frmPuestos);
		panel.add(tabPuestos);
		
//		FormPanel frmPrevision = new FormPanel();
//		frmPrevision.setHeaderVisible(false);
//		frmPrevision.setAutoHeight(true);
//		utils.loadPrevision(frmPrevision);
//		
		
		TabItem tabPrevision = new TabItem("Previsión de vestuario");
		tabPrevision.add(new MenuIconos());
		//tabPrevision.add(frmPrevision);
		tabPrevision.addListener(Events.Select, new Listener<ComponentEvent>(){
 
			@Override
			public void handleEvent(ComponentEvent be) {
				final TextField<String> anio = new TextField<String>();  
				anio.setStyleAttribute("margin", "10px 2px 10px 2px");
				anio.setWidth("272px");
				Dialog anyo = new Dialog();
				anyo.setHideOnButtonClick(true);
				anyo.setHeading("Introduce el año sobre el que quieres realizar la consulta de previsión");
				anyo.setButtons(Dialog.OKCANCEL);
				anyo.getButtonById(Dialog.OK).addSelectionListener(new SelectionListener<ButtonEvent>(){

					@Override
					public void componentSelected(ButtonEvent ce) {
						//Aqui iria el generar informe
					}
					
				});
				anyo.add(anio, new BorderLayoutData(LayoutRegion.CENTER));
				anyo.show();
			}
			
		});
		
		panel.add(tabPrevision);
	}
}