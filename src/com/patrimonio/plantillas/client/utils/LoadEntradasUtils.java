package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
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
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.patrimonio.plantillas.client.widgets.Stock;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoEliminados;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionTotal;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionarArticulo;

public class LoadEntradasUtils {
	
	
	public void loadFormNuevoPedido(FormPanel panel) {
		
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
	  
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaPedido = new DateField();
	    fechaPedido.getPropertyEditor().setFormat(dtFormat);
	    fechaPedido.setTitle("Seleccione la fecha en la que desea realizar el pedido");
	    fechaPedido.setFieldLabel("Fecha del pedido");
	    fechaPedido.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaPedido,new FormData("40%"));  
	  
	    TextField<String> numPedido = new TextField<String>();  
	    numPedido.setFieldLabel("Número de pedido");  
	    left.add(numPedido,formData);
	    
	    Label lblProveedores = new Label("Proveedor:");
	    lblProveedores.setStyleName("etiqueta");
	    ListBox lstProveedores = new ListBox();
	    lstProveedores.setVisibleItemCount(1);
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
	    
	    ButtonGroup gButtonsCP = new ButtonGroup(2);
	    Button bt1 = new Button(), bt2 = new Button();
	   
	    bt1.setText("Aceptar");
	    bt1.setStyleAttribute("padding-right", "5px");
	    bt2.setText("Buscar");
	    bt2.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoBuscar dlgBuscar = new DialogoBuscar();
				dlgBuscar.show();				
			}
	    });
	    
	    gButtonsCP.add(bt1);
	    gButtonsCP.add(bt2);
	    gButtonsCP.setBodyBorder(false);
	    gButtonsCP.setBorders(false);
	    gButtonsCP.addStyleName("botonesFuncionales");
	    
	    cpRight.setBottomComponent(gButtonsCP);
	    
	    right.add(cpRight);
	    
	    main.add(left, new ColumnData(.4));  
	    main.add(right, new ColumnData(.6));  
	  
	    panel.add(main, new FormData("100%"));  
	  

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
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b2 = new Button(), b3 = new Button();
	   
	    b2.setText("Guardar Pedido");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Vaciar");

	    
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    
	    panel.add(gButtons);  
	  
	}
	

	public void loadFormRecepcion(FormPanel frmRecepcionPedidos) {

		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmRecepcionPedidos.setHeading("FormPanel");  
		frmRecepcionPedidos.setSize("100%", "100%");  
		frmRecepcionPedidos.setBodyBorder(false);
		frmRecepcionPedidos.setLabelAlign(LabelAlign.TOP);  
		frmRecepcionPedidos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	  
	    // introducimos los valores a seleccionar para comenzar el pedido
	    LayoutContainer left = new LayoutContainer();  
	    
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	  
	    TextField<String> numPeticion = new TextField<String>();  
	    numPeticion.setFieldLabel("Número de petición");
	    numPeticion.setValue("24/2013");
	    left.add(numPeticion,formData);
	    
	    
	    // vamos creando el pedido
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	  
	    TextField<String> fechaPeticion = new TextField<String>();  
	    fechaPeticion.setFieldLabel("Fecha de la petición");
	    fechaPeticion.setValue("10/05/2013");
	    right.add(fechaPeticion,formData);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.getAriaSupport().setPresentation(true);  
	    
	    TextField<String> codigoProveedor = new TextField<String>();  
	    codigoProveedor.setFieldLabel("Proveedor");
	    codigoProveedor.setValue("B28227775 - ABAISA S.L.");
	    bottom.add(codigoProveedor,formData);

	  

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
	    
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Relación de artículos de la petición");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    
	    
	    cp.add(grid);
	    bottom.add(cp, formData);
	 
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Recepción Total");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
					DialogoRecepcionTotal dlgTotal = new DialogoRecepcionTotal();
					dlgTotal.show();
			}
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Recepción por Artículo");
	    b2.addListener(Events.OnClick, new Listener<BaseEvent>(){ 
			@Override
			public void handleEvent(BaseEvent be) {
				DialogoRecepcionarArticulo dlgBuscarArticulo = new DialogoRecepcionarArticulo();
				dlgBuscarArticulo.show();				
			}
	    });
	    
	    
	    b2.setStyleAttribute("padding-left", "5px");
	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    DataProxy proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar toolBar = new PagingToolBar(50); 
	    toolBar.bind(loader);
	    toolBar.addStyleName("paginacion");
	    
		main.add(left, new ColumnData(.4));  
		main.add(right, new ColumnData(.6));  
		main.add(bottom, new ColumnData(1));
		main.add(toolBar, new ColumnData(.6));
		main.add(gButtons, new ColumnData(.4));
		
		
		frmRecepcionPedidos.add(main, new FormData("100%"));  
	    
	}


	public void loadFormNuevoArticulo(FormPanel frmNuevoArticulo) {
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmNuevoArticulo.setSize("100%", "100%");  
		frmNuevoArticulo.setBodyBorder(false);
		frmNuevoArticulo.setLabelAlign(LabelAlign.TOP);  
		frmNuevoArticulo.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingLeft", "100px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    
	   
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    lstSeccion.addItem("...");
	    left.add(lblSeccion,formData);
	    left.add(lstSeccion,formData);

	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    lstFamilia.setWidth("400px");
	    lstFamilia.addItem("...");
	    right.add(lblFamilia,formData);
	    right.add(lstFamilia,formData);
	    
	    Label lblSubFamilia = new Label("Subfamilia:");
	    lblSubFamilia.setStyleName("etiqueta");
	    ListBox lstSubFamilia = new ListBox();
	    lstSubFamilia.setVisibleItemCount(1);
	    lstSubFamilia.setWidth("400px");
	    lstSubFamilia.addItem("...");
	    right.add(lblSubFamilia,formData);
	    right.add(lstSubFamilia,formData);
	    
	    
	    TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    TextField<String> obsArt = new TextField<String>();  
	    obsArt.setFieldLabel("Observaciones");
	    bottom.add(obsArt,formData);
	    
	    
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.HORIZONTAL);
	    ContentPanel cpExistencias = new ContentPanel();
	    cpExistencias.setHeading("Existencias");
	    cpExistencias.setLayout(rgtLayout);  
	    cpExistencias.setHeight("90px");
	    cpExistencias.setFrame(true);
	    cpExistencias.setStyleAttribute("paddingBottom", "10px");
	    
	    Label lblMinimas = new Label();
	    lblMinimas.setText("Mínimas");
	    
	    TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	   
	    
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
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Grabar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Deshacer");
	    b2.setStyleAttribute("padding-right", "5px");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    bottom.add(cpExistencias,formData);
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeaderVisible(false);
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    	    
	    cp.add(grid);
	      
	    
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));

	    main.add(cp, new ColumnData(1));
	    main.add(gButtons, new ColumnData(1));
	    
	    frmNuevoArticulo.add(main, new FormData("100%"));
	    
	}

	
	public void loadFormArticuloEliminado(FormPanel frmArticuloEliminado) { 

		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmArticuloEliminado.setSize("100%", "100%");  
		frmArticuloEliminado.setBodyBorder(false);
		frmArticuloEliminado.setLabelAlign(LabelAlign.TOP);  
		frmArticuloEliminado.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    
	   
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    left.add(lblSeccion,formData);
	    left.add(lstSeccion,formData);

	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    right.add(lblFamilia,formData);
	    right.add(lstFamilia,formData);
	    
	    Label lblSubFamilia = new Label("Subfamilia:");
	    lblSubFamilia.setStyleName("etiqueta");
	    ListBox lstSubFamilia = new ListBox();
	    lstSubFamilia.setVisibleItemCount(1);
	    right.add(lblSubFamilia,formData);
	    right.add(lstSubFamilia,formData);
	    
	    
	    TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    TextField<String> obsArt = new TextField<String>();  
	    obsArt.setFieldLabel("Observaciones");
	    bottom.add(obsArt,formData);
	    
	    
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.HORIZONTAL);
	    ContentPanel cpExistencias = new ContentPanel();
	    cpExistencias.setHeading("Existencias");
	    cpExistencias.setLayout(rgtLayout);  
	    cpExistencias.setHeight("90px");
	    cpExistencias.setFrame(true);
	    cpExistencias.setStyleAttribute("paddingBottom", "10px");
	    
	    Label lblMinimas = new Label();
	    lblMinimas.setText("Mínimas");
	    
	    TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));

	    bottom.add(cpExistencias,formData);
	    
	    Label lblProveedor = new Label("Proveedor:");
	    lblProveedor.setStyleName("etiqueta");
	    ListBox lstProveedor = new ListBox();
	    lstProveedor.setVisibleItemCount(1);
	    bottom.add(lblProveedor,formData);
	    bottom.add(lstProveedor,formData);
	    
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Buscar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoEliminados eliminados = new DialogoEliminados();
				eliminados.show();
			}
	    	
	    });
	    
	    b2.setText("Deshacer");
	    b2.setStyleAttribute("padding-right", "5px");
	   	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	   

	    
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));

	    main.add(gButtons, new ColumnData(1));
	    
	    frmArticuloEliminado.add(main, new FormData("100%"));
		
	}
	
}
