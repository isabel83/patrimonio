package com.patrimonio.plantillas.client.widgets.forms;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HideMode;
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

	int panelActivo = 0;
	
	String[] titulos={"Consultas > Pedidos", "Consultas > Albaranes de material SOLICITADO", "Consultas > Albaranes de material SERVIDO", "Consultas > Control de material SOLICITADO y SERVIDO", "Consultas > Artículos", "Consultas > Previsión de vestuario"};
	
	public FormConsultas(int posicion) {
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
			      //  Log.debug("EN UNCAUGHT: " + e.getCause()); 
			    }  
			    // do module loading stuff  
			  });    
		

		FormPanel form = new FormPanel();
		form.setHeaderVisible(false);
		form.setExpanded(true);
		form.setAutoHeight(true);
		form.setBodyBorder(false);
		form.setBorders(false);
		loadPanelConsultas(form, panelActivo);
		add(form);
		
			
	} 
	
	
	private void loadPanelConsultas(final FormPanel form, int activo) {
		switch(activo){
			case 0: utils.loadFormConsultaPedido(form); break;
			case 1: utils.loadFormConsultaAlbMatSolicitado(form); break;
			case 2: utils.loadFormConsultaAlbMatServido(form); break;
			case 3: utils.loadFormConsultaControlMaterial(form); break;
			case 4: utils.loadFormConsultaArticulos(form); break;
			case 5: form.getHeader().addStyleName("titular");
					form.setHeaderVisible(true);
					utils.loadFormConsultaPrevision(form);
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
							utils.titularPrevisiones += anio.getValue();
							form.setHeading(utils.titularPrevisiones);
							form.setExpanded(true);
						}
						
					});
					anyo.add(anio, new BorderLayoutData(LayoutRegion.CENTER));
					anyo.show();
					
					break;
		}
		
	}


}
