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

	int panelActivo = 0;
	
	String[] titulos={"Entradas > Nuevo pedido", "Entradas > Recepción de pedidos", "Entradas > Nuevo artículo", "Entradas > Recuperar artículo eliminado"};
	
	public FormEntradas(int numPanel) {
		panelActivo = numPanel;
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
			    
			  });    
		
		
	
		
		//Log.debug("antes de cargar los tab panels del Formulario");
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadEntradas(tabPanel);
		tabPanel.setSelection(tabPanel.getItem(panelActivo));
		add(tabPanel);
		
		//Log.debug("Terminando en el onrender del formPage");
			
	}
	
	
	private void loadEntradas(TabPanel panel) {
		
		
		FormPanel frmNuevoPedido = new FormPanel();
		frmNuevoPedido.setHeaderVisible(false);
		frmNuevoPedido.setAutoHeight(true);
		utils.loadFormNuevoPedido(frmNuevoPedido);
		
		TabItem tabNuevo = new TabItem();
		tabNuevo.add(new MenuIconos());
		tabNuevo.add(frmNuevoPedido);
		//tabNuevo.setIconStyle("tabNuevo");
		panel.add(tabNuevo);
		
		FormPanel frmRecepcionPedidos = new FormPanel();
		frmRecepcionPedidos.setHeaderVisible(false);
		frmRecepcionPedidos.setAutoHeight(true);
		utils.loadFormRecepcion(frmRecepcionPedidos);
		
		TabItem tabRecepcion = new TabItem();
		tabRecepcion.add(new MenuIconos());
		tabRecepcion.add(frmRecepcionPedidos);
		panel.add(tabRecepcion);
		
		FormPanel frmNuevoArticulo = new FormPanel();
		frmNuevoArticulo.setHeaderVisible(false);
		frmNuevoArticulo.setAutoHeight(true);
		utils.loadFormNuevoArticulo(frmNuevoArticulo);
		
		
		TabItem tabArticulo = new TabItem();
		tabArticulo.add(new MenuIconos());
		tabArticulo.add(frmNuevoArticulo);
		panel.add(tabArticulo);
		
		FormPanel frmArticuloEliminado = new FormPanel();
		frmArticuloEliminado.setHeaderVisible(false);
		frmArticuloEliminado.setAutoHeight(true);
		utils.loadFormArticuloEliminado(frmArticuloEliminado);
		
		
		TabItem tabEliminado = new TabItem();
		tabEliminado.add(new MenuIconos());
		tabEliminado.add(frmArticuloEliminado);
		panel.add(tabEliminado);
		
//		FormPanel frmNuevoPedido = new FormPanel();
//		frmNuevoPedido.setHeaderVisible(false);
//		frmNuevoPedido.setAutoHeight(true);
//		utils.loadFormNuevoPedido(frmNuevoPedido);
//		
		//TabItem tabNumInventario = new TabItem();
		//tabNumInventario.add(new MenuIconos());
		//tabNumInventario.add(frmNuevoPedido);
		//tabNuevo.setIconStyle("tabNuevo");
		//panel.add(tabNumInventario);
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
