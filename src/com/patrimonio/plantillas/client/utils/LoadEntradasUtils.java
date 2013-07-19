package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
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
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoEliminados;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionTotal;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoRecepcionarArticulo;
import com.patrimonio.plantillas.shared.RpcUtilsArticulos;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;
import com.patrimonio.plantillas.shared.clases.Articulos;

public class LoadEntradasUtils {
	
	RpcUtilsArticulos artiUtils = new RpcUtilsArticulos();
	RpcUtilsProveedores provUtils = new RpcUtilsProveedores();
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	protected long seccion=0;
	protected long familia=0;
	protected long subfamilia=0;
	
	
	public void loadFormNuevoPedido(final FormPanel panel) {
		
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
	   
	  
	    final LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	  
	    // introducimos los valores a seleccionar para comenzar el pedido
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	  
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    final DateField fechaPedido = new DateField();
	    fechaPedido.getPropertyEditor().setFormat(dtFormat);
	    fechaPedido.setValue(new Date()); //fecha de hoy por defecto
	    fechaPedido.setTitle("Seleccione la fecha en la que desea realizar el pedido");
	    fechaPedido.setFieldLabel("Fecha del pedido");
	    fechaPedido.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaPedido,new FormData("40%"));  
	  
	    final TextField<String> numPedido = new TextField<String>();  
	    numPedido.setFieldLabel("Número de pedido");  
	    left.add(numPedido,formData);
	    
	    final TextField<String> nifProv = new TextField<String>();  
	    nifProv.setFieldLabel("NIF del proveedor");
	    nifProv.disable();
	    left.add(nifProv,formData);
	    

	    ListStore<BaseModel> proveedores = new ListStore<BaseModel>();  
	    provUtils.loadProveedoresCombo(proveedores);
	  
	    final ComboBox<BaseModel> combo = new ComboBox<BaseModel>();  
	    combo.setEmptyText("Selecciona un proveedor");  
	    combo.setStore(proveedores);  
	    combo.setDisplayField("nombre");  
	    combo.setValueField("id");
	    combo.setFieldLabel("Proveedor");
	    combo.setWidth(150);  
	    combo.setTriggerAction(TriggerAction.ALL);  
	    
	    left.add(combo,formData);
	    
	    // vamos creando el pedido
	    final LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setVisible(false);
	    right.setLayout(layout);  
	    
	    final LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout);
	    
	    
	    ContentPanel cpRight = new ContentPanel();
	    RowLayout rgtLayout = new RowLayout();
	    rgtLayout.setOrientation(Orientation.VERTICAL);
	    cpRight.setLayout(rgtLayout);
	    cpRight.setHeading("Seleccione los artículos a incluir en el pedido");
	    cpRight.setBodyBorder(false);
	    
	   // Log.debug("Antes de ir a cargar el combo");
	    final ListStore<BaseModel> art = new ListStore<BaseModel>();  
	   
	    
	    final ComboBox<BaseModel> comboA = new ComboBox<BaseModel>();  
	    comboA.setEmptyText("Selecciona un articulo");  
	    comboA.setStore(art);  
	    comboA.setDisplayField("nombre");  
	    comboA.setValueField("id");
	    comboA.setFieldLabel("Artículo");
	    comboA.setWidth(150);  
	    cpRight.add(comboA, new RowData(1,-1, new Margins(4)));
	    
	    Label lblMarca = new Label("Marca:");
	    lblMarca.addStyleName("etiqueta");
	    final TextField<String> marca = new TextField<String>();  
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
	  
	    
	    final CheckBox seleccionar = new CheckBox();  
	    seleccionar.setFieldLabel("Seleccionar");
	    midLeft.add(seleccionar, formData);
	    	    
	    final TextField<Integer> cantidad = new TextField<Integer>();  
	    cantidad.setFieldLabel("Cantidad");  
	    cantidad.setValue(0);
	    midRight.add(cantidad, formData);
	    
	    subMain.add(midLeft, new ColumnData(.5));
	    subMain.add(midRight, new ColumnData(.5));  
	    cpRight.add(subMain,new RowData(1, -1, new Margins(4,0,4,4)));
	    
	    
	    
	    Label lblObs = new Label("Observaciones");
	    lblObs.addStyleName("etiqueta");
	    cpRight.add(lblObs, formData);
	    final TextArea observaciones = new TextArea();
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
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("marca");  
	    column.setHeader("Marca");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	    final ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getArticulos()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    final ColumnModel cm = new ColumnModel(configs);  
	  
	    DataProxy proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true);
	    
	    
	    final Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setStyleAttribute("borderTop", "none");  
	    grid.setBorders(false);
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	      
	    
	   
	    
	    final PagingToolBar toolBar = new PagingToolBar(50); 
	    toolBar.bind(loader);
	    toolBar.setStyleName("paginacion");
	    
	    final ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Pedido");
	    cp.setFrame(true);
	    cp.setVisible(false);
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    
	    cp.add(grid);
	    bottom.add(cp, formData);
	    
	    
	    final ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1 = new Button(), b2 = new Button();
	   
	    b1.setText("Guardar Pedido");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				//aqui tenemos que seleccionar todos los datos para  V_PEDIDO
				
			}
	    	
	    });
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Vaciar");
	    b2.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				fechaPedido.setValue(new Date());
				numPedido.clear();
				nifProv.clear();
				marca.clear();
				combo.clear();
				comboA.clear();
				seleccionar.clear();
				cantidad.clear();
				observaciones.setValue(null);
				right.setVisible(false);
				grid.reconfigure(store, cm);
				bottom.setVisible(false);
				gButtons.setVisible(false);
				main.recalculate();
				main.layout(true);
			}
	    	
	    });
	    
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.setVisible(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    //***************************************************************************************//
	    combo.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //si es nulo, estaremos vaciando la pantalla
					long id= se.getSelectedItem().get("id");
				//	artiUtils.loadArticulosCombo(art,id);
					right.setVisible(true);
					right.recalculate();
					main.layout(true);
				}
			}
	    	
	    });
	    bt1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				//Pedidos p = artiUtils.loadArticuloGrid(comboA.getValue());
				//grid.getStore().add(p);
				cp.setVisible(true);
				cp.recalculate();
				gButtons.setVisible(true);
				bottom.setVisible(true);
				bottom.recalculate();
				main.layout(true);
			}
	    	
	    });
	    
	    main.add(left, new ColumnData(.4));  
	    main.add(right, new ColumnData(.6));  
	    main.add(bottom, new ColumnData(1));
	    main.add(gButtons, new ColumnData(1));
	    panel.add(main, new FormData("100%"));  
	    
 
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
	    left.add(numPeticion,formData);
	    
	    
	    // vamos creando el pedido
	    LayoutContainer right = new LayoutContainer(); 
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	  
	    TextField<String> fechaPeticion = new TextField<String>();  
	    fechaPeticion.setFieldLabel("Fecha de la petición");
	    right.add(fechaPeticion,formData);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.getAriaSupport().setPresentation(true);  
	    
	    TextField<String> codigoProveedor = new TextField<String>();  
	    codigoProveedor.setFieldLabel("Proveedor");
	    bottom.add(codigoProveedor,formData);

	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("pedido");  
	    column.setHeader("Pedido");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("recepcion");  
	    column.setHeader("Recepción");  
	    column.setWidth(100);  
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("anulado");  
	    column.setHeader("Anulado");  
	    column.setWidth(100);  
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	    column = new ColumnConfig();  
	    column.setId("marca");  
	    column.setHeader("Marca");  
	    column.setWidth(200);  
	    configs.add(column);  
	      
	    
	    ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Relación de artículos de la petición");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
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
	    
	    
	   
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Sección");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    
	    
	    left.add(comboSeccion, formData);

	    final ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboFamilia = new ComboBox<BaseModel>();  
	    comboFamilia.setEmptyText("Selecciona una familia");  
	    comboFamilia.setStore(familias);  
	    comboFamilia.setDisplayField("nombre");  
	    comboFamilia.setValueField("id");
	    comboFamilia.setFieldLabel("Familia");
	    comboFamilia.setWidth(150);  
	    comboFamilia.setEnabled(false);
	    
	    right.add(comboFamilia,formData);
	    
	    final ListStore<BaseModel> subFamilia = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboSubFamilia = new ComboBox<BaseModel>();  
	    comboSubFamilia.setEmptyText("Selecciona una subfamilia");  
	    comboSubFamilia.setStore(subFamilia);  
	    comboSubFamilia.setDisplayField("nombre");  
	    comboSubFamilia.setValueField("id");
	    comboSubFamilia.setFieldLabel("Subfamilia");
	    comboSubFamilia.setWidth(150);  
	    comboSubFamilia.setEnabled(false);
	    
	    right.add(comboSubFamilia,formData);
	    
	    
	    final TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    final TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    final TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    final TextField<String> obsArt = new TextField<String>();  
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
	    
	    final TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    final TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    final TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	   
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("marcar");  
	    column.setHeader("Marcar");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nif");  
	    column.setHeader("NIF");  
	    column.setWidth(150);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(200); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("actividad");  
	    column.setHeader("Actividad");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	      
	    
	    final ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    final ColumnModel cm = new ColumnModel(configs);  
	  
	    final Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setAutoExpandColumn("nombre");  
	    grid.setAutoExpandColumn("actividad");
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
//	    grid.addListener(Events.Attach, new Listener<GridEvent<BeanModel>>() {  
//	        public void handleEvent(GridEvent<BeanModel> be) {  
//	          loader.load(0, 50);  
//	        }  
//	      });  
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Grabar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				artiUtils.checkValuesAndSaveArticulo((int)seccion,(int)familia,(int)subfamilia,Integer.parseInt(codigoArt.getValue()),nombreArt.getValue(),
						marcaArt.getValue(),obsArt.getValue(),Integer.parseInt(minimas.getValue()),Integer.parseInt(idoneas.getValue()));
			}
	    });
	    b2.setText("Deshacer");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				comboSeccion.clear();
				comboFamilia.clear();
				comboSubFamilia.clear();
				codigoArt.clear();
				nombreArt.clear();
				marcaArt.clear();
				obsArt.clear();
				minimas.clear();
				idoneas.clear();
				reales.clear();
				grid.reconfigure(store, cm);
			}
	    	
	    });
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    bottom.add(cpExistencias,formData);
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(false);  
	    cp.setHeading("Proveedores");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
	    cp.setHeight("200px");
	    cp.setStyleAttribute("paddingLeft", "10px");
	    cp.setStyleAttribute("paddingRight", "10px");
	    cp.add(grid);
	    
	    /*LE DAMOS A LOS COMBOS EL LISTENER*/
	    comboSeccion.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //estamos vaciando el panel
					seccion = se.getSelectedItem().get("id");
					famiUtils.loadFamiliasComboFiltrado(familias, seccion);
					comboFamilia.setEnabled(true);
					comboFamilia.recalculate();
				}
			}
	    	
	    });
	    
	    comboFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null){ //estamos vaciando el panel
					familia = se.getSelectedItem().get("id");
					subUtils.loadSubFamiliasComboFiltrado(subFamilia, familia);
					comboSubFamilia.setEnabled(true);
					comboSubFamilia.recalculate();
				}
			}
	    	
	    });
	    
	    comboSubFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				if(se.getSelectedItem()!=null)
				subfamilia = se.getSelectedItem().get("id");
			}
	    	
	    });
	    
	    
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
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    
	    
	    left.add(comboSeccion, formData);

	    final ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboFamilia = new ComboBox<BaseModel>();  
	    comboFamilia.setEmptyText("Selecciona una familia");  
	    comboFamilia.setStore(familias);  
	    comboFamilia.setDisplayField("nombre");  
	    comboFamilia.setValueField("id");
	    comboFamilia.setFieldLabel("Familias");
	    comboFamilia.setWidth(150);  
	    comboFamilia.setEnabled(false);
	    
	    right.add(comboFamilia,formData);
	    
	    final ListStore<BaseModel> subFamilia = new ListStore<BaseModel>();  
	    final ComboBox<BaseModel> comboSubFamilia = new ComboBox<BaseModel>();  
	    comboSubFamilia.setEmptyText("Selecciona una subfamilia");  
	    comboSubFamilia.setStore(subFamilia);  
	    comboSubFamilia.setDisplayField("nombre");  
	    comboSubFamilia.setValueField("id");
	    comboSubFamilia.setFieldLabel("Subfamilias");
	    comboSubFamilia.setWidth(150);  
	    comboSubFamilia.setEnabled(false);
	    
	    right.add(comboSubFamilia,formData);
	    
	    
	    final TextField<String> codigoArt = new TextField<String>();  
	    codigoArt.setFieldLabel("Código de Artículo");
	    bottom.add(codigoArt,formData);
	    
	    final TextField<String> nombreArt = new TextField<String>();  
	    nombreArt.setFieldLabel("Nombre del artículo");
	    bottom.add(nombreArt,formData);
	    
	    final TextField<String> marcaArt = new TextField<String>();  
	    marcaArt.setFieldLabel("Marca del artículo");
	    bottom.add(marcaArt,formData);
	    
	    final TextField<String> obsArt = new TextField<String>();  
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
	    
	    final TextField<String> minimas = new TextField<String>();  
	    cpExistencias.add(lblMinimas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(minimas, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    
	    Label lblIdoneas = new Label();
	    lblIdoneas.setText("Idoneas");
	    
	    final TextField<String> idoneas = new TextField<String>();  

	    cpExistencias.add(lblIdoneas, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(idoneas, new RowData(-1, -1, new Margins(20)));
	    
	    
	    Label lblReales = new Label();
	    lblReales.setText("Reales");
	    
	    final TextField<String> reales = new TextField<String>();  

	    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
	    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));

	    bottom.add(cpExistencias,formData);
	    
	    /*LE DAMOS A LOS COMBOS EL LISTENER*/
	    comboSeccion.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				seccion = se.getSelectedItem().get("id");
				famiUtils.loadFamiliasComboFiltrado(familias, seccion);
				comboFamilia.setEnabled(true);
				comboFamilia.recalculate();
			}
	    	
	    });
	    
	    comboFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				familia = se.getSelectedItem().get("id");
				subUtils.loadSubFamiliasComboFiltrado(subFamilia, familia);
				comboSubFamilia.setEnabled(true);
				comboSubFamilia.recalculate();
			}
	    	
	    });
	    
	    comboSubFamilia.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				subfamilia = se.getSelectedItem().get("id");
			}
	    	
	    });
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Buscar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				Articulos articuloBusqueda = new Articulos();
				DialogoEliminados eliminados = new DialogoEliminados(articuloBusqueda);
				eliminados.show();
			}
	    	
	    });
	    
	    b2.setText("Deshacer");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				comboSeccion.reset();
				comboFamilia.reset();
				comboSubFamilia.reset();
				codigoArt.clear();
				nombreArt.clear();
				marcaArt.clear();
				obsArt.clear();
				minimas.clear();
				idoneas.clear();
				reales.clear();
			}
	    	
	    });
	   	    
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
