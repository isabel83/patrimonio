package com.patrimonio.plantillas.client.design;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.menu.MenuBar;
import com.extjs.gxt.ui.client.widget.menu.MenuBarItem;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.TabItem;

import com.patrimonio.plantillas.client.design.MenuIconos;
import com.patrimonio.plantillas.client.design.Stock;

public class FormPage {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		//RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
		Image image = new Image("resources/images/logoPatrimonioPrueba.png");
		RootPanel.get().add(image);
		
		
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
		
		
		/** CARGA DE MENU **/
		RootPanel.get().add(menuPrincipal);
		RootPanel.get().setWidgetPosition(menuPrincipal, 2, 126);

		
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setAutoHeight(true);
		tabPanel.setWidth("95%");
		tabPanel.setBodyBorder(false);
		tabPanel.setBorders(false);
		loadEntradas(tabPanel);
		
		RootPanel.get().add(tabPanel);
		RootPanel.get().setWidgetPosition(tabPanel, 15, 157);
		
				
	}

	private void loadEntradas(TabPanel panel) {
		
		FormPanel formularioDemo = new FormPanel();
		formularioDemo.setHeaderVisible(false);
		formularioDemo.setAutoHeight(true);
		loadFormulario(formularioDemo);
		
		TabItem tabNuevo = new TabItem("Nuevo Pedido");
		tabNuevo.add(new MenuIconos());
		tabNuevo.add(formularioDemo);
		tabNuevo.setIconStyle("tabNuevo");
		
		panel.add(tabNuevo);
		TabItem tabRecepcion = new TabItem("Recepcion de Pedidos");
//		tabRecepcion.addListener(Events.Select, new Listener<ComponentEvent>() {  
//		      public void handleEvent(ComponentEvent be) {  
//		          Window.alert("Event Tab Was Selected");  
//		        }  
//		      });  
		panel.add(tabRecepcion);
		TabItem tabArticulo = new TabItem("Nuevo articulo");
		tabArticulo.add(new MenuIconos());
		panel.add(tabArticulo);
		TabItem tabEliminado = new TabItem("Recuperar articulo eliminado");
		panel.add(tabEliminado);
		
	}

	private void loadFormulario(FormPanel panel) {
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
	    panel.setHeading("FormPanel");  
	    panel.setSize("100%", "100%");  
	    panel.setBodyBorder(false);
	    panel.setLabelAlign(LabelAlign.TOP);  
	    panel.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	  
	    // introducimos los valores a seleccionar para comenzar el pedido
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	  
	    DateField fechaPedido = new DateField();
	    fechaPedido.setTitle("Seleccione la fecha en la que desea realizar el pedido");
	    fechaPedido.setFieldLabel("Fecha del pedido");
	    left.add(fechaPedido,formData);  
	  
	    TextField<String> numPedido = new TextField<String>();  
	    numPedido.setFieldLabel("Número de pedido");  
	    left.add(numPedido,formData);
	    
	    Label lblProveedores = new Label("Proveedor:");
	    lblProveedores.setStyleName("etiqueta");
	    ListBox lstProveedores = new ListBox();
	    lstProveedores.setVisibleItemCount(1);
	    lstProveedores.addItem("3M España S.A.");
	    lstProveedores.addItem("ABAISA S.L.");
	    lstProveedores.addItem("AF STEELCASE S.A.");
	    lstProveedores.addItem("AGUDEL S.L.");
	    lstProveedores.addItem("AHOSMA S.L.");
	    lstProveedores.addItem("...");
	    left.add(lblProveedores,formData);
	    left.add(lstProveedores,formData);
	    
	    // vamos creando el pedido
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    
	    ContentPanel cpRight = new ContentPanel();
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.VERTICAL);
	    cpRight.setLayout(rgtLayout);
	    cpRight.setHeading("Seleccione los artículos a incluir en el pedido");
	    cpRight.setBodyBorder(false);
	    
	    Label lblArticulos = new Label("Artículos:");
	    lblArticulos.addStyleName("etiqueta");
	    
	    ListBox lstArticulos = new ListBox();
	    lstArticulos.setVisibleItemCount(1);
	    lstArticulos.addItem("Seleccione artículo");
	    lstArticulos.addItem("Taza de café 10cl. Mod-Alicia");
	    lstArticulos.addItem("Plato de café Mod-Alicia");
	    lstArticulos.addItem("Plato de 26cm.");
	    lstArticulos.addItem("Cafetera/Lechera 0.7L Mod-Alicia");
	    lstArticulos.addItem("...");
	    
	    cpRight.add(lblArticulos,  new RowData(1, -1, new Margins(4,1,4,4)));
	    cpRight.add(lstArticulos, new RowData(1, -1, new Margins(1,4,4,4)));
	    
	    Label lblMarca = new Label("Marca:");
	    lblMarca.addStyleName("etiqueta");
	    TextField<String> marca = new TextField<String>();  
	    marca.setEnabled(false);
	    cpRight.add(lblMarca,  new RowData(1, -1, new Margins(4,1,4,4)));
	    cpRight.add(marca, new RowData(1, -1, new Margins(1,4,4,4)));	   
	  	    
	    LayoutContainer subMain = new LayoutContainer();  
	    subMain.setLayout(new ColumnLayout());  
	    
	    LayoutContainer midRight = new LayoutContainer();  
	    midRight.setStyleAttribute("paddingLeft", "10px");  
	    FormLayout lay = new FormLayout(); 
	    lay.setLabelAlign(LabelAlign.TOP);
	    midRight.setLayout(lay);  
	    
	    LayoutContainer midLeft = new LayoutContainer();  
	    midLeft.setStyleAttribute("paddingRight", "10px");
	    lay = new FormLayout();  
	    lay.setLabelAlign(LabelAlign.TOP);
	    midLeft.setLayout(lay); 
	    midLeft.addStyleName("check");
	  
	    
	    CheckBox seleccionar = new CheckBox();  
	    seleccionar.setFieldLabel("Seleccionar");
	    midLeft.add(seleccionar, formData);
	    	    
	    TextField<Integer> cantidad = new TextField<Integer>();  
	    cantidad.setFieldLabel("Cantidad");  
	    cantidad.setValue(0);
	    midRight.add(cantidad, formData);
	    
	    subMain.add(midLeft, new ColumnData(.5));
	    subMain.add(midRight, new ColumnData(.5));  
	    cpRight.add(subMain,new RowData(1, -1, new Margins(4,0,4,4)));
	    
	    
	    
	    Label lblObs = new Label("Observaciones");
	    lblObs.addStyleName("etiqueta");
	    cpRight.add(lblObs, formData);
	    TextArea observaciones = new TextArea();
	    observaciones.setVisibleLines(4);
	    cpRight.add(observaciones,new RowData(1, -1, new Margins(4)));
	    
	    
	    right.add(cpRight);
	    
	    main.add(left, new ColumnData(.4));  
	    main.add(right, new ColumnData(.6));  
	  
	    panel.add(main, new FormData("100%"));  
	  
	    
	    //esto sera el grid con los datos del pedido, la seleccion de materiales
	    
//	    
//	    HtmlEditor a = new HtmlEditor();  
//	    a.setFieldLabel("Comment");  
//	    a.setHeight(200);  
//	    panel.add(a, new FormData("100%"));  
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("cantidad");  
	    column.setHeader("Cantidad");  
	    column.setWidth(200);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("articulo");  
	    column.setHeader("Artículo");  
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	      
	    
	    ListStore<Stock> store = new ListStore<Stock>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<Stock> grid = new Grid<Stock>(store,cm);
	    grid.setStyleAttribute("borderTop", "none");  
	    grid.setAutoExpandColumn("articulo");  
	    grid.setAutoExpandColumn("observaciones");
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    bottom.setLayout(new FlowLayout()); 
	    bottom.getAriaSupport().setPresentation(true);  
	    
	    
	    DataProxy proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar toolBar = new PagingToolBar(50); 
	    toolBar.bind(loader);
//	    toolBar.disable();
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Pedido");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    
	    cp.setBottomComponent(toolBar);
	    
	    cp.add(grid);
	    bottom.add(cp);
	    panel.add(bottom); 
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Modificar Seleccion");
	    b1.setEnabled(false);
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Guardar Pedido");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Vaciar");
	    b3.setEnabled(false);
	    b4.setText("Salir");
	    b4.setStyleAttribute("padding-left", "5px");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    
	    panel.add(gButtons);  
	  
	   // vp.add(panel);  
		
		
	}


	private  List<Stock> getStocks() {  
		List<Stock> stocks = new ArrayList<Stock>();
		
		 stocks.add(new Stock(12, "AAPL", "2344dqd", "sdffsdf"));
		 stocks.add(new Stock(250, "AAPL", "dgyt 656bn ff", "sdffsf"));
		 stocks.add(new Stock(13, "AAPL", "6yhb ", ""));
		 stocks.add(new Stock(6, "AAPL", "2344fdgdqd", ""));
		
		 return stocks;
	}
}
