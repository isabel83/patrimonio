package com.patrimonio.plantillas.client.widgets.forms;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.patrimonio.plantillas.client.utils.LoadConsultasUtils;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormConsultas extends ContentPanel{
	LoadConsultasUtils utils = new LoadConsultasUtils();

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
		
		
	
		
		Log.debug("antes de cargar los tab panels del Formulario");
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadPanelConsultas(tabPanel);
		
		add(tabPanel);
		
		Log.debug("Terminando en el onrender del formPage");
			
	} 
	
	
	private void loadPanelConsultas(TabPanel panel) {
		
		FormPanel frmConsultaPedido = new FormPanel();
		frmConsultaPedido.setHeaderVisible(false);
		frmConsultaPedido.setExpanded(true);
		frmConsultaPedido.setAutoHeight(true);
		utils.loadFormConsultaPedido(frmConsultaPedido);
		
		TabItem tabConsultaPedido = new TabItem("Pedidos");
		tabConsultaPedido.add(new MenuIconos());
		tabConsultaPedido.add(frmConsultaPedido);
		panel.add(tabConsultaPedido);
		
		final FormPanel frmConsultaAlbaranesMSolicitado = new FormPanel();
		frmConsultaAlbaranesMSolicitado.setHeaderVisible(false);
		frmConsultaAlbaranesMSolicitado.setExpanded(true);
		frmConsultaAlbaranesMSolicitado.setAutoHeight(true);
		utils.loadFormConsultaAlbMatSolicitado(frmConsultaAlbaranesMSolicitado);
		
		TabItem tabAlbaranesMSolicitado = new TabItem("Albaranes de material SOLICITADO");
		tabAlbaranesMSolicitado.add(new MenuIconos());
		tabAlbaranesMSolicitado.add(frmConsultaAlbaranesMSolicitado);
		panel.add(tabAlbaranesMSolicitado);
		
		final FormPanel frmConsultaAlbaranesMServido = new FormPanel();
		frmConsultaAlbaranesMServido.setHeaderVisible(false);
		frmConsultaAlbaranesMServido.setExpanded(true);
		frmConsultaAlbaranesMServido.setAutoHeight(true);
		utils.loadFormConsultaAlbMatServido(frmConsultaAlbaranesMServido);
		
		TabItem tabAlbaranesMServido = new TabItem("Albaranes de material SERVIDO");
		tabAlbaranesMServido.add(new MenuIconos());
		tabAlbaranesMServido.add(frmConsultaAlbaranesMServido);
		panel.add(tabAlbaranesMServido);
		
		final FormPanel frmControlMaterial = new FormPanel();
		frmControlMaterial.setHeaderVisible(false);
		frmControlMaterial.setExpanded(true);
		frmControlMaterial.setAutoHeight(true);
		utils.loadFormConsultaControlMaterial(frmControlMaterial);
		
		TabItem tabControlMaterial = new TabItem("Control de material SOLICITADO y SERVIDO");
		tabControlMaterial.add(new MenuIconos());
		tabControlMaterial.add(frmControlMaterial);
		panel.add(tabControlMaterial);
		
		final FormPanel frmConsultaArticulos = new FormPanel();
		frmConsultaArticulos.setHeaderVisible(false);
		frmConsultaArticulos.setExpanded(true);
		frmConsultaArticulos.setAutoHeight(true);
		utils.loadFormConsultaArticulos(frmConsultaArticulos);
		
		TabItem tabCArticulos = new TabItem("Artículos");
		tabCArticulos.add(new MenuIconos());
		tabCArticulos.add(frmConsultaArticulos);
		panel.add(tabCArticulos);
		
		final FormPanel frmCPrevision = new FormPanel();
		frmCPrevision.setHeaderVisible(false);
		frmCPrevision.setAutoHeight(true);
		frmCPrevision.setBodyBorder(false);
		utils.loadFormConsultaPrevision(frmCPrevision);
		
		TabItem tabCprevision = new TabItem("Previsión de vestuario");
		tabCprevision.addListener(Events.Select, new Listener<ComponentEvent>(){
 
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
						Log.debug("Estamos en el OK del dialogo y el valor de año es: " + anio.getValue());
						Log.debug("El valor del formulario es: " + frmCPrevision);
						utils.titularPrevisiones += anio.getValue();
						frmCPrevision.setExpanded(true);
						frmCPrevision.recalculate();
					}
					
				});
				anyo.add(anio, new BorderLayoutData(LayoutRegion.CENTER));
				anyo.show();
			}
			
		});
		tabCprevision.add(new MenuIconos());
		tabCprevision.add(frmCPrevision);
		panel.add(tabCprevision);
		
		
	}
}
