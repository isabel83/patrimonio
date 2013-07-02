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
	
	String[] titulos={"Mantenimiento de tablas > Proveedores", "Mantenimiento de tablas > Destinatarios", "Mantenimiento de tablas > Secciones", "Mantenimiento de tablas > Familias", "Mantenimiento de tablas > Subfamilias", "Mantenimiento de tablas > Puestos de trabajo"};
	
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
		
		TabItem tabProveedores = new TabItem();
		tabProveedores.add(new MenuIconos());
		tabProveedores.add(frmProveedores);
		tabProveedores.disableTextSelection(true);
		panel.add(tabProveedores);
		
		final FormPanel frmDestinatarios = new FormPanel();
		frmDestinatarios.setHeaderVisible(false);
		frmDestinatarios.setExpanded(true);
		frmDestinatarios.setAutoHeight(true);
		utils.loadFormDestinatarios(frmDestinatarios);
		
		TabItem tabDestinatarios = new TabItem();
		tabDestinatarios.add(new MenuIconos());
		tabDestinatarios.add(frmDestinatarios);
		panel.add(tabDestinatarios);
		
		final FormPanel frmSecciones = new FormPanel();
		frmSecciones.setHeaderVisible(false);
		frmSecciones.setExpanded(true);
		frmSecciones.setAutoHeight(true);
		utils.loadFormSecciones(frmSecciones);
		
		TabItem tabSecciones = new TabItem();
		tabSecciones.add(new MenuIconos());
		tabSecciones.add(frmSecciones);
		panel.add(tabSecciones);
		
		final FormPanel frmFamilias = new FormPanel();
		frmFamilias.setHeaderVisible(false);
		frmFamilias.setExpanded(true);
		frmFamilias.setAutoHeight(true);
		utils.loadFormFamilias(frmFamilias);
		
		TabItem tabFamilias = new TabItem();
		tabFamilias.add(new MenuIconos());
		tabFamilias.add(frmFamilias);
		panel.add(tabFamilias);
		
		final FormPanel frmSubFamilias = new FormPanel();
		frmSubFamilias.setHeaderVisible(false);
		frmSubFamilias.setExpanded(true);
		frmSubFamilias.setAutoHeight(true);
		utils.loadFormSubFamilias(frmSubFamilias);
		
		TabItem tabSubFamilias = new TabItem();
		tabSubFamilias.add(new MenuIconos());
		tabSubFamilias.add(frmSubFamilias);
		panel.add(tabSubFamilias);
		
		final FormPanel frmPuestos = new FormPanel();
		frmPuestos.setHeaderVisible(false);
		frmPuestos.setAutoHeight(true);
		frmPuestos.setBodyBorder(false);
		utils.loadFormPuestos(frmPuestos);
		
		TabItem tabPuestos = new TabItem();
		tabPuestos.add(new MenuIconos());
		tabPuestos.add(frmPuestos);
		panel.add(tabPuestos);
		
		
	}
}
