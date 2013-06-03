package com.patrimonio.plantillas.client.widgets.menus;


import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;

public class MenuIconos extends Composite {
	
	public MenuIconos(){

		
		MenuBar menuBar = new MenuBar(false);
		initWidget(menuBar);
		
		Command busca = new Command() {
			@Override
			public void execute() {
				DialogoBuscar dlgBuscar = new DialogoBuscar();
				dlgBuscar.show();
			}
		};
				 

		//cargamos las imagenes
		MenuItem nuevo = new MenuItem("<img src='resources/images/icons/application_add.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem editar  = new MenuItem("<img src='resources/images/icons/application_edit.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem eliminar  = new MenuItem("<img src='resources/images/icons/bin.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem guardar  = new MenuItem("<img src='resources/images/icons/accept.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem imprimir  = new MenuItem("<img src='resources/images/icons/printer.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem actualizar  = new MenuItem("<img src='resources/images/icons/arrow_refresh.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem buscar  = new MenuItem("<img src='resources/images/icons/page_find.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem anterior  = new MenuItem("<img src='resources/images/icons/resultset_previous.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem siguiente  = new MenuItem( "<img src='resources/images/icons/resultset_next.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem copiar  = new MenuItem( "<img src='resources/images/icons/page_copy.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem pegar  = new MenuItem( "<img src='resources/images/icons/page_paste.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem ampliar  = new MenuItem( "<img src='resources/images/icons/zoom_in.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem reducir  = new MenuItem("<img src='resources/images/icons/zoom_out.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem info  = new MenuItem("<img src='resources/images/icons/information.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem ayuda  = new MenuItem("<img src='resources/images/icons/info-green.png' height='15px' width='15px'/>", true, menuBar);
		MenuItem salir  = new MenuItem("<img src='resources/images/icons/door_out.png' height='15px' width='15px'/>", true, menuBar);
		
		//metemos cada boton en la barra de herramientas
		buscar.setCommand(busca);
		menuBar.addItem(nuevo);
		menuBar.addItem(editar);
		editar.setEnabled(false);
		editar.addStyleName("iconoDisabled");
		menuBar.addItem(guardar);
		eliminar.setEnabled(false);
		eliminar.addStyleName("iconoDisabled");
		menuBar.addItem(eliminar);
		menuBar.addSeparator();		
		menuBar.addItem(imprimir);
		actualizar.setEnabled(false);
		actualizar.addStyleName("iconoDisabled");
		menuBar.addItem(actualizar);
		menuBar.addSeparator();
		menuBar.addItem(buscar);
		copiar.setEnabled(false);
		copiar.addStyleName("iconoDisabled");
		menuBar.addItem(copiar);
		pegar.setEnabled(false);
		pegar.addStyleName("iconoDisabled");
		menuBar.addItem(pegar);
		menuBar.addSeparator();		
		menuBar.addItem(anterior);
		menuBar.addItem(siguiente);
		menuBar.addSeparator();		
		menuBar.addItem(ampliar);
		menuBar.addItem(reducir);
		menuBar.addSeparator();
		menuBar.addItem(info);
		menuBar.addItem(ayuda);
		menuBar.addSeparator();
		menuBar.addItem(salir);
		
		
		menuBar.addStyleName("limpiar");
		
		
	}
}
