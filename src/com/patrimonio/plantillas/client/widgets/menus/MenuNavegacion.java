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

		Log.debug("Estamos en el menu navegacion");		
		/** ENTRADAS DE ALMACEN **/
		
		MenuBar menuPrincipal = new MenuBar();
		initWidget(menuPrincipal);
		
		Menu submnuEntradas = new Menu();
				
		MenuItem itemPedidos = new MenuItem("Nuevo Pedido");
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
		mnuEntradas.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				Log.debug("En root tenemos : " + rootPanel.getWidgetCount());
				rootPanel.clear();
				rootPanel.add(new FormEntradas());
			}
			
		});
		menuPrincipal.add(mnuEntradas);
		
		/** SALIDAS DE ALMACEN **/
		
		Menu submnuSalidas = new Menu();
		
		MenuItem itemNuevaSolicitud = new MenuItem("Nueva solicitud");
		submnuSalidas.add(itemNuevaSolicitud);
		
		MenuItem itemAlbaranes = new MenuItem("Albaranes de solicitud");
		submnuSalidas.add(itemAlbaranes);
		
		SeparatorMenuItem separatorMenuItem_1 = new SeparatorMenuItem();
		submnuSalidas.add(separatorMenuItem_1);
		
		MenuItem itemBajaArticulos = new MenuItem("Baja de art\u00EDculos");
		submnuSalidas.add(itemBajaArticulos);
		
		MenuBarItem menuSalidas = new MenuBarItem("Salida", submnuSalidas);
		menuSalidas.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				rootPanel.clear();
				rootPanel.add(new FormSalidas());
			}
			
		});
		menuPrincipal.add(menuSalidas);
		
		/** CONSULTAS **/
		
		Menu submnuConsultas = new Menu();
		
		MenuItem itemCnsPedidos = new MenuItem("Pedidos");
		submnuConsultas.add(itemCnsPedidos);
		
		MenuItem itemCnsMaterialSolicitado = new MenuItem("Albaran Material solicitado");
		submnuConsultas.add(itemCnsMaterialSolicitado);
		
		MenuItem itemCnsMaterialServido = new MenuItem("Albaran Material servido");
		submnuConsultas.add(itemCnsMaterialServido);
		
		MenuBarItem menuConsultas = new MenuBarItem("Consultas", submnuConsultas);
		menuConsultas.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				rootPanel.clear();
				rootPanel.add(new FormConsultas());
			}
			
		});
		menuPrincipal.add(menuConsultas);
		
		/** INFORMES **/
		
		Menu submnuInformes = new Menu();
		
		MenuItem itemInPedidos = new MenuItem("Pedidos");
		submnuInformes.add(itemInPedidos);
		MenuBarItem mnbrtmInformes = new MenuBarItem("Informes", submnuInformes);
		mnbrtmInformes.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				rootPanel.clear();
				rootPanel.add(new FormInformes());
			}
			
		});
		menuPrincipal.add(mnbrtmInformes);
		
		
		/** MANTENIMIENTO DE ALMACEN **/
		
		Menu submnuMantenimiento = new Menu();
		
		MenuItem itemProveedores = new MenuItem("Proveedores");
		submnuMantenimiento.add(itemProveedores);
		
		MenuItem itemDestinatarios = new MenuItem("Destinatarios");
		itemDestinatarios.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				Log.debug("En el clic de destinatarios");
				rootPanel.add(new FormMntTablas());
			}
			
		});
		submnuMantenimiento.add(itemDestinatarios);
		MenuBarItem menuMantenimientoTablas = new MenuBarItem("Mantenimiento Tablas", submnuMantenimiento);
		menuMantenimientoTablas.addListener(Events.OnClick, new Listener<MenuEvent>(){

			@Override
			public void handleEvent(MenuEvent be) {
				Log.debug("En el clic de mantenimiento");
				rootPanel.clear();
				rootPanel.add(new FormMntTablas());
				
			}
			
		});
		menuPrincipal.add(menuMantenimientoTablas);
		
		/** OPERACIONES ESPECIALES **/
		
		Menu submnuEspeciales = new Menu();
		
		MenuItem itemPrevisionDeVestuario = new MenuItem("Prevision de vestuario");
		submnuEspeciales.add(itemPrevisionDeVestuario);
		
		MenuBarItem mnuOperacionesEspeciales = new MenuBarItem("Operaciones Especiales", submnuEspeciales);
		mnuOperacionesEspeciales.addListener(Events.Select, new SelectionListener<ComponentEvent>(){

			@Override
			public void componentSelected(ComponentEvent ce) {
				rootPanel.clear();
				rootPanel.add(new FormOpEspeciales());
				
			}
			
		});
		mnuOperacionesEspeciales.addStyleName("mnuFinal");
		mnuOperacionesEspeciales.disable();
		menuPrincipal.add(mnuOperacionesEspeciales);
		
		menuPrincipal.addStyleName("menu-principal");
		
		
		Log.debug("Estamos al final del constructor MenuNavegacion");
		
	}
}
