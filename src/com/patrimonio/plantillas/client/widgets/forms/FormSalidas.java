package com.patrimonio.plantillas.client.widgets.forms;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
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
			        //Log.debug("EN UNCAUGHT: " + e.getLocalizedMessage()); 
			    }  
			    // do module loading stuff  
			  });    
		
		
	
		
		//Log.debug("antes de cargar los tab panels del Formulario");
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadSalidas(tabPanel);
		tabPanel.setSelection(tabPanel.getItem(panelActivo));
		add(tabPanel);
		
		//Log.debug("Terminando en el onrender del formPage");
			
	}
	
	
	private void loadSalidas(TabPanel panel) {
		
		FormPanel frmNuevaSolicitud = new FormPanel();
		frmNuevaSolicitud.setHeaderVisible(false);
		frmNuevaSolicitud.setExpanded(true);
		frmNuevaSolicitud.setAutoHeight(true);
		utils.loadFormNuevaSolicitud(frmNuevaSolicitud);
		
		TabItem tabNueva = new TabItem();
		tabNueva.add(new MenuIconos());
		tabNueva.add(frmNuevaSolicitud);
		tabNueva.disableTextSelection(true);
		panel.add(tabNueva);
		
		final FormPanel frmAlbaranes = new FormPanel();
		frmAlbaranes.setHeaderVisible(false);
		frmAlbaranes.setExpanded(true);
		frmAlbaranes.setAutoHeight(true);
		utils.loadFormAlbaranes(frmAlbaranes);
		
		TabItem tabAlbaranes = new TabItem();
		tabAlbaranes.add(new MenuIconos());
		tabAlbaranes.add(frmAlbaranes);
		tabAlbaranes.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				frmAlbaranes.recalculate();
				
			}
			
		});
		panel.add(tabAlbaranes);
		
		final FormPanel frmBajaArticulo = new FormPanel();
		frmBajaArticulo.setHeaderVisible(false);
		frmBajaArticulo.setExpanded(true);
		frmBajaArticulo.setAutoHeight(true);
		utils.loadFormBajaArticulo(frmBajaArticulo);
		
		TabItem tabBaja = new TabItem();
		tabBaja.add(new MenuIconos());
		tabBaja.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				//Log.debug("EN EL CLICK DEL TAB BAJA");
				frmBajaArticulo.recalculate();
				frmBajaArticulo.repaint();
				
			}
			
		});
		tabBaja.add(frmBajaArticulo);
		panel.add(tabBaja);
		
		
	}
}
