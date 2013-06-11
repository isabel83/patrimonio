package com.patrimonio.plantillas.client.widgets.menus;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.patrimonio.plantillas.client.widgets.forms.FormConsultas;
import com.patrimonio.plantillas.client.widgets.forms.FormEntradas;
import com.patrimonio.plantillas.client.widgets.forms.FormInformes;
import com.patrimonio.plantillas.client.widgets.forms.FormMntTablas;
import com.patrimonio.plantillas.client.widgets.forms.FormOpEspeciales;
import com.patrimonio.plantillas.client.widgets.forms.FormSalidas;

public class MenuNavegacion extends Composite {
	
	public MenuNavegacion(final RootPanel rootPanel){

		//Log.debug("Estamos en el menu navegacion");		
		/** ENTRADAS DE ALMACEN **/
		
		MenuBar menuPrincipal = new MenuBar();
		initWidget(menuPrincipal);
		
		Menu submnuEntradas = new Menu();
				
		MenuItem itemPedidos = new MenuItem("Nuevo Pedido");
		itemPedidos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormEntradas form = new FormEntradas();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemPedidos);

		MenuItem itemRecepcionPedido = new MenuItem("Recepcion de Pedidos");
		submnuEntradas.add(itemRecepcionPedido);
		
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		submnuEntradas.add(separatorMenuItem);
		
		MenuItem itemNuevoArticulo = new MenuItem("Nuevo articulo");
		submnuEntradas.add(itemNuevoArticulo);
		
		MenuItem itemRecuperarArticulo = new MenuItem("Recuperar articulo");
		submnuEntradas.add(itemRecuperarArticulo);
		
		MenuBarItem mnuEntradas = new MenuBarItem("Entradas", submnuEntradas);
		menuPrincipal.add(mnuEntradas);
		
		/** SALIDAS DE ALMACEN **/
		
		Menu submnuSalidas = new Menu();
		
		MenuItem itemNuevaSolicitud = new MenuItem("Nueva solicitud");
		itemNuevaSolicitud.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormSalidas form = new FormSalidas();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuSalidas.add(itemNuevaSolicitud);
		
		MenuItem itemAlbaranes = new MenuItem("Albaranes de solicitud");
		submnuSalidas.add(itemAlbaranes);
		
		SeparatorMenuItem separatorMenuItem_1 = new SeparatorMenuItem();
		submnuSalidas.add(separatorMenuItem_1);
		
		MenuItem itemBajaArticulos = new MenuItem("Baja de art\u00EDculos");
		submnuSalidas.add(itemBajaArticulos);
		
		MenuBarItem menuSalidas = new MenuBarItem("Salida", submnuSalidas);
		menuPrincipal.add(menuSalidas);
		
		/** CONSULTAS **/
		
		Menu submnuConsultas = new Menu();
		
		MenuItem itemCnsPedidos = new MenuItem("Pedidos");
		itemCnsPedidos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsPedidos);
		
		MenuItem itemCnsMaterialSolicitado = new MenuItem("Albaran Material solicitado");
		submnuConsultas.add(itemCnsMaterialSolicitado);
		
		MenuItem itemCnsMaterialServido = new MenuItem("Albaran Material servido");
		submnuConsultas.add(itemCnsMaterialServido);
		
		MenuBarItem menuConsultas = new MenuBarItem("Consultas", submnuConsultas);
		menuPrincipal.add(menuConsultas);
		
		/** INFORMES **/
		
		Menu submnuInformes = new Menu();
		
		MenuItem itemInPedidos = new MenuItem("Pedidos");
		itemInPedidos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInPedidos);
		
		MenuBarItem mnbrtmInformes = new MenuBarItem("Informes", submnuInformes);
		menuPrincipal.add(mnbrtmInformes);
		
		
		/** MANTENIMIENTO DE ALMACEN **/
		
		Menu submnuMantenimiento = new Menu();
		
		MenuItem itemProveedores = new MenuItem("Proveedores");
		itemProveedores.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemProveedores);
		
		MenuItem itemDestinatarios = new MenuItem("Destinatarios");
		submnuMantenimiento.add(itemDestinatarios);

		
		MenuBarItem menuMantenimientoTablas = new MenuBarItem("Mantenimiento Tablas", submnuMantenimiento);
		menuPrincipal.add(menuMantenimientoTablas);
		
		/** OPERACIONES ESPECIALES **/
		
		Menu submnuEspeciales = new Menu();
		
		MenuItem itemPrevisionDeVestuario = new MenuItem("Prevision de vestuario");
		itemPrevisionDeVestuario.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormOpEspeciales form = new FormOpEspeciales();
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEspeciales.add(itemPrevisionDeVestuario);
		
		MenuBarItem mnuOperacionesEspeciales = new MenuBarItem("Operaciones Especiales", submnuEspeciales);
	
		mnuOperacionesEspeciales.addStyleName("mnuFinal");
		mnuOperacionesEspeciales.disable();
		menuPrincipal.add(mnuOperacionesEspeciales);
		
		menuPrincipal.addStyleName("menu-principal");
		
		
		//Log.debug("Estamos al final del constructor MenuNavegacion");
		
	}

	
}
