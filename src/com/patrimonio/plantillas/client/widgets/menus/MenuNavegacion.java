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
				FormEntradas form = new FormEntradas(0);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemPedidos);

		MenuItem itemRecepcionPedido = new MenuItem("Recepcion de Pedidos");
		itemRecepcionPedido.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormEntradas form = new FormEntradas(1);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemRecepcionPedido);
		
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		submnuEntradas.add(separatorMenuItem);
		
		MenuItem itemNuevoArticulo = new MenuItem("Nuevo articulo");
		itemNuevoArticulo.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormEntradas form = new FormEntradas(2);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemNuevoArticulo);
		
		MenuItem itemRecuperarArticulo = new MenuItem("Recuperar articulo");
		itemRecuperarArticulo.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormEntradas form = new FormEntradas(3);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemRecuperarArticulo);
		
		MenuItem itemNumInv = new MenuItem("Poner Números de inventario");
		itemNumInv.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormEntradas form = new FormEntradas(4);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuEntradas.add(itemNumInv);
		
		MenuBarItem mnuEntradas = new MenuBarItem("Entradas", submnuEntradas);
		menuPrincipal.add(mnuEntradas);
		
		/** SALIDAS DE ALMACEN **/
		
		Menu submnuSalidas = new Menu();
		
		MenuItem itemNuevaSolicitud = new MenuItem("Nueva solicitud");
		itemNuevaSolicitud.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormSalidas form = new FormSalidas(0);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuSalidas.add(itemNuevaSolicitud);
		
		MenuItem itemAlbaranes = new MenuItem("Albaranes de solicitud");
		itemAlbaranes.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormSalidas form = new FormSalidas(1);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuSalidas.add(itemAlbaranes);
		
		SeparatorMenuItem separatorMenuItem_1 = new SeparatorMenuItem();
		submnuSalidas.add(separatorMenuItem_1);
		
		MenuItem itemBajaArticulos = new MenuItem("Baja de artículos");
		itemBajaArticulos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormSalidas form = new FormSalidas(2);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuSalidas.add(itemBajaArticulos);
		
		MenuBarItem menuSalidas = new MenuBarItem("Salida", submnuSalidas);
		menuPrincipal.add(menuSalidas);
		
		/** CONSULTAS **/
		
		Menu submnuConsultas = new Menu();
		
		MenuItem itemCnsPedidos = new MenuItem("Pedidos");
		itemCnsPedidos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(0);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsPedidos);
		
		MenuItem itemCnsMaterialSolicitado = new MenuItem("Albaranes Material SOLICITADO");
		itemCnsMaterialSolicitado.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(1);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsMaterialSolicitado);
		
		MenuItem itemCnsMaterialServido = new MenuItem("Albaranes Material SERVIDO");
		itemCnsMaterialServido.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(2);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsMaterialServido);
		
		MenuItem itemCnsMaterialSerSol = new MenuItem("Control de material SOLICITADO y SERVIDO");
		itemCnsMaterialSerSol.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(3);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsMaterialSerSol);
		
		MenuItem itemCnsArticulos = new MenuItem("Artículos");
		itemCnsArticulos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(4);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsArticulos);
		
		MenuItem itemCnsPrevision = new MenuItem("Previsión de vestuario");
		itemCnsPrevision.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormConsultas form = new FormConsultas(5);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuConsultas.add(itemCnsPrevision);
		
		MenuBarItem menuConsultas = new MenuBarItem("Consultas", submnuConsultas);
		menuPrincipal.add(menuConsultas);
		
		/** INFORMES **/
		
		Menu submnuInformes = new Menu();
		
		MenuItem itemInPedidos = new MenuItem("Pedidos");
		itemInPedidos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(0);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInPedidos);
		
		MenuItem itemInSolMaterial = new MenuItem("Solicitudes de Material");
		itemInSolMaterial.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(1);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInSolMaterial);
		
		MenuItem itemInArticulos = new MenuItem("Artículos");
		itemInArticulos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(2);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInArticulos);
		
		MenuItem itemInProveedores = new MenuItem("Proveedores");
		itemInProveedores.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(3);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInProveedores);
		
		MenuItem itemInPuestos = new MenuItem("Puestos de trabajo");
		itemInPuestos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(4);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInPuestos);
		
		MenuItem itemInPrevision = new MenuItem("Previsión de vestuario");
		itemInPrevision.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormInformes form = new FormInformes(5);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuInformes.add(itemInPrevision);
		
		
		MenuBarItem mnbrtmInformes = new MenuBarItem("Informes", submnuInformes);
		menuPrincipal.add(mnbrtmInformes);
		
		
		/** MANTENIMIENTO DE ALMACEN **/
		
		Menu submnuMantenimiento = new Menu();
		
		MenuItem itemProveedores = new MenuItem("Proveedores");
		itemProveedores.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(0);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemProveedores);
		
		MenuItem itemDestinatarios = new MenuItem("Destinatarios");
		itemDestinatarios.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(1);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemDestinatarios);

		MenuItem itemSecciones = new MenuItem("Secciones");
		itemSecciones.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(2);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemSecciones);
		
		MenuItem itemFamilias = new MenuItem("Familias");
		itemFamilias.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(3);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemFamilias);
		
		MenuItem itemSubFamilias = new MenuItem("Subfamilias");
		itemSubFamilias.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(4);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemSubFamilias);
		
		MenuItem itemPuestos = new MenuItem("Puestos de trabajo");
		itemPuestos.addSelectionListener(new SelectionListener<MenuEvent>(){

			@Override
			public void componentSelected(MenuEvent ce) {
				FormMntTablas form = new FormMntTablas(5);
				form.setBodyBorder(false);
				form.setBorders(false);
				form.setHeaderVisible(false);
				RootPanel.get("principalContainer").getElement().setInnerHTML("");
				RootPanel.get("principalContainer").add(form);
			}
			
		});
		submnuMantenimiento.add(itemPuestos);
		
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
		//submnuEspeciales.add(itemPrevisionDeVestuario);
		
		MenuBarItem mnuOperacionesEspeciales = new MenuBarItem("Operaciones Especiales", submnuEspeciales);
	
		mnuOperacionesEspeciales.addStyleName("mnuFinal");
		mnuOperacionesEspeciales.disable();
		menuPrincipal.add(mnuOperacionesEspeciales);
		
		menuPrincipal.addStyleName("menu-principal");
		
		
		//Log.debug("Estamos al final del constructor MenuNavegacion");
		
	}

	
}
