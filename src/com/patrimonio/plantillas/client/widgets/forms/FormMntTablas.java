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
import com.patrimonio.plantillas.client.utils.LoadMantenimientoUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormMntTablas extends ContentPanel{
	LoadMantenimientoUtils utils = new LoadMantenimientoUtils();

	int panelActivo = 0;
	
	public FormMntTablas(int posicion) {
		panelActivo = posicion;
	}


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
			        Log.debug("EN UNCAUGHT: " + e.getCause()); 
			    }  
			    // do module loading stuff  
			  });    
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadPanelConsultas(tabPanel);
		tabPanel.setSelection(tabPanel.getItem(panelActivo));
		add(tabPanel);
			
	} 
	
	
	private void loadPanelConsultas(TabPanel panel) {
		
		FormPanel frmProveedores = new FormPanel();
		frmProveedores.setHeaderVisible(false);
		frmProveedores.setExpanded(true);
		frmProveedores.setAutoHeight(true);
		utils.loadFormProveedores(frmProveedores);
		
		TabItem tabProveedores = new TabItem("Proveedores");
		tabProveedores.add(new MenuIconos());
		tabProveedores.add(frmProveedores);
		panel.add(tabProveedores);
		
		final FormPanel frmDestinatarios = new FormPanel();
		frmDestinatarios.setHeaderVisible(false);
		frmDestinatarios.setExpanded(true);
		frmDestinatarios.setAutoHeight(true);
		utils.loadFormDestinatarios(frmDestinatarios);
		
		TabItem tabDestinatarios = new TabItem("Destinatarios");
		tabDestinatarios.add(new MenuIconos());
		tabDestinatarios.add(frmDestinatarios);
		panel.add(tabDestinatarios);
		
		final FormPanel frmSecciones = new FormPanel();
		frmSecciones.setHeaderVisible(false);
		frmSecciones.setExpanded(true);
		frmSecciones.setAutoHeight(true);
		utils.loadFormSecciones(frmSecciones);
		
		TabItem tabSecciones = new TabItem("Secciones");
		tabSecciones.add(new MenuIconos());
		tabSecciones.add(frmSecciones);
		panel.add(tabSecciones);
		
		final FormPanel frmFamilias = new FormPanel();
		frmFamilias.setHeaderVisible(false);
		frmFamilias.setExpanded(true);
		frmFamilias.setAutoHeight(true);
		utils.loadFormFamilias(frmFamilias);
		
		TabItem tabFamilias = new TabItem("Familias");
		tabFamilias.add(new MenuIconos());
		tabFamilias.add(frmFamilias);
		panel.add(tabFamilias);
		
		final FormPanel frmSubFamilias = new FormPanel();
		frmSubFamilias.setHeaderVisible(false);
		frmSubFamilias.setExpanded(true);
		frmSubFamilias.setAutoHeight(true);
		utils.loadFormSubFamilias(frmSubFamilias);
		
		TabItem tabSubFamilias = new TabItem("Subfamilias");
		tabSubFamilias.add(new MenuIconos());
		tabSubFamilias.add(frmSubFamilias);
		panel.add(tabSubFamilias);
		
		final FormPanel frmPuestos = new FormPanel();
		frmPuestos.setHeaderVisible(false);
		frmPuestos.setAutoHeight(true);
		frmPuestos.setBodyBorder(false);
		utils.loadFormPuestos(frmPuestos);
		
		TabItem tabPuestos = new TabItem("Puestos de trabajo");
		tabPuestos.add(new MenuIconos());
		tabPuestos.add(frmPuestos);
		panel.add(tabPuestos);
		
		
	}
}
