package com.patrimonio.plantillas.client.widgets.menus;

import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;

public class MenuPrincipal extends Composite{
	
	public MenuPrincipal() {
		/** ENTRADAS DE ALMACEN **/
		
		MenuBar menuPrincipal = new MenuBar();
		
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
		menuPrincipal.add(menuConsultas);
		
		/** INFORMES **/
		
		Menu submnuInformes = new Menu();
		
		MenuItem itemInPedidos = new MenuItem("Pedidos");
		submnuInformes.add(itemInPedidos);
		MenuBarItem mnbrtmInformes = new MenuBarItem("Informes", submnuInformes);
		menuPrincipal.add(mnbrtmInformes);
		
		
		/** MANTENIMIENTO DE ALMACEN **/
		
		Menu submnuMantenimiento = new Menu();
		
		MenuItem itemProveedores = new MenuItem("Proveedores");
		submnuMantenimiento.add(itemProveedores);
		
		MenuItem itemDestinatarios = new MenuItem("Destinatarios");
		submnuMantenimiento.add(itemDestinatarios);
		MenuBarItem menuMantenimientoTablas = new MenuBarItem("Mantenimiento Tablas", submnuMantenimiento);
		menuPrincipal.add(menuMantenimientoTablas);
		
		/** OPERACIONES ESPECIALES **/
		
		Menu submnuEspeciales = new Menu();
		
		MenuItem itemPrevisionDeVestuario = new MenuItem("Prevision de vestuario");
		submnuEspeciales.add(itemPrevisionDeVestuario);
		
		MenuBarItem mnuOperacionesEspeciales = new MenuBarItem("Operaciones Especiales", submnuEspeciales);
		mnuOperacionesEspeciales.addStyleName("mnuFinal");
		menuPrincipal.add(mnuOperacionesEspeciales);
		
	}

}
