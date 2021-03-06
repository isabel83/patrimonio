package com.patrimonio.plantillas.client.widgets.forms;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;

import com.patrimonio.plantillas.client.utils.LoadEntradasUtils;
import com.patrimonio.plantillas.client.widgets.menus.MenuIconos;

public class FormEntradas extends ContentPanel{

	LoadEntradasUtils utils = new LoadEntradasUtils();

	@Override
	protected void onLoad() {
		
		super.onLoad();

		recalculate();
	}
	

	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);

	//	Log.debug("En el onRender del FormPage");

		
		setLayout(new BorderLayout());
		setBodyBorder(false);
		setBorders(false);
		setHeaderVisible(false);
		setSize(1024, 768);
		
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
		loadEntradas(tabPanel);
		
		add(tabPanel);
		
		//Log.debug("Terminando en el onrender del formPage");
			
	}
	
	
	private void loadEntradas(TabPanel panel) {
		
		FormPanel frmNuevoPedido = new FormPanel();
		frmNuevoPedido.setHeaderVisible(false);
		frmNuevoPedido.setAutoHeight(true);
		utils.loadFormNuevoPedido(frmNuevoPedido);
		
		TabItem tabNuevo = new TabItem("Nuevo Pedido");
		tabNuevo.add(new MenuIconos());
		tabNuevo.add(frmNuevoPedido);
		//tabNuevo.setIconStyle("tabNuevo");
		panel.add(tabNuevo);
		
		FormPanel frmRecepcionPedidos = new FormPanel();
		frmRecepcionPedidos.setHeaderVisible(false);
		frmRecepcionPedidos.setAutoHeight(true);
		utils.loadFormRecepcion(frmRecepcionPedidos);
		
		TabItem tabRecepcion = new TabItem("Recepcion de Pedidos");
		tabRecepcion.add(new MenuIconos());
		tabRecepcion.add(frmRecepcionPedidos);
		panel.add(tabRecepcion);
		
		FormPanel frmNuevoArticulo = new FormPanel();
		frmNuevoArticulo.setHeaderVisible(false);
		frmNuevoArticulo.setAutoHeight(true);
		utils.loadFormNuevoArticulo(frmNuevoArticulo);
		
		
		TabItem tabArticulo = new TabItem("Nuevo articulo");
		tabArticulo.add(new MenuIconos());
		tabArticulo.add(frmNuevoArticulo);
		panel.add(tabArticulo);
		
		FormPanel frmArticuloEliminado = new FormPanel();
		frmArticuloEliminado.setHeaderVisible(false);
		frmArticuloEliminado.setAutoHeight(true);
		utils.loadFormArticuloEliminado(frmArticuloEliminado);
		
		
		TabItem tabEliminado = new TabItem("Recuperar articulo eliminado");
		tabEliminado.add(new MenuIconos());
		tabEliminado.add(frmArticuloEliminado);
		panel.add(tabEliminado);
		
		
	}

//	
//
//
//	private  List<Stock> getStocks() {  
//		List<Stock> stocks = new ArrayList<Stock>();
//		
//		 stocks.add(new Stock(12, "AAPL", "2344dqd", "sdffsdf"));
//		 stocks.add(new Stock(250, "AAPL", "dgyt 656bn ff", "sdffsf"));
//		 stocks.add(new Stock(13, "AAPL", "6yhb ", ""));
//		 stocks.add(new Stock(6, "AAPL", "2344fdgdqd", ""));
//		
//		 return stocks;
//	}
//	
	
	
	
}
