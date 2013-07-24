package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoAlbaranFecha;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoNuevoArticulo;
import com.patrimonio.plantillas.shared.RpcUtilsDestinatarios;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsPersonas;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;
import com.patrimonio.plantillas.shared.clases.Destinatarios;

public class LoadSalidasUtils {
	
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsDestinatarios destiUtils = new RpcUtilsDestinatarios();
	RpcUtilsPersonas personUtils = new RpcUtilsPersonas();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	protected long seccion=0;
	protected long familia=0;
	protected long subfamilia=0;
	
	
	public void loadFormNuevaSolicitud(FormPanel frmNuevaSolicitud) {

		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmNuevaSolicitud.setSize("100%", "100%");  
		frmNuevaSolicitud.setBodyBorder(false);
		frmNuevaSolicitud.setLabelAlign(LabelAlign.TOP);  
		frmNuevaSolicitud.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    
	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    final DateField fechaSolicitud = new DateField();
	    fechaSolicitud.setValue(new Date());
	    fechaSolicitud.getPropertyEditor().setFormat(dtFormat);
	    fechaSolicitud.setTitle("Seleccione la fecha en la que desea realizar la solicitud");
	    fechaSolicitud.setFieldLabel("Fecha de solicitud");
	    fechaSolicitud.setStyleAttribute("paddingBottom", "5px");
	    left.add(fechaSolicitud,new FormData("40%"));  
	    
	    final TextField<String> numSolicitud = new TextField<String>();  
	    numSolicitud.setFieldLabel("Número de solicitud");
	    right.add(numSolicitud,formData);

	    final ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> comboSeccion = new ComboBox<BaseModel>();  
	    comboSeccion.setEmptyText("Selecciona una sección");  
	    comboSeccion.setStore(secciones);  
	    comboSeccion.setDisplayField("nombre");  
	    comboSeccion.setValueField("id");
	    comboSeccion.setFieldLabel("Secciones");
	    comboSeccion.setWidth(150);  
	    comboSeccion.setEnabled(true);
	    bottom.add(comboSeccion, new FormData("100%"));
	    

	    final ListStore<Destinatarios> unidades = new ListStore<Destinatarios>();  
	    destiUtils.loadUnidadCombo(unidades);
	  
	    final ComboBox<Destinatarios> comboUnidad = new ComboBox<Destinatarios>();  
	    comboUnidad.setEmptyText("Selecciona un destinatario");  
	    comboUnidad.setStore(unidades);  
	    comboUnidad.setDisplayField("nombre");  
	    comboUnidad.setValueField("id");
	    comboUnidad.setFieldLabel("Destinatario");
	    comboUnidad.setWidth(150);  
	    comboUnidad.setEnabled(true);
	    bottom.add(comboUnidad, new FormData("100%"));
	    
	    final ListStore<BaseModel> personas = new ListStore<BaseModel>();  
	    personUtils.loadPersonasCombo(personas);
	  
	    final ComboBox<BaseModel> comboPersonas = new ComboBox<BaseModel>();  
	    comboPersonas.setEmptyText("Selecciona una persona");  
	    comboPersonas.setStore(personas);  
	    comboPersonas.setDisplayField("nombre");  
	    comboPersonas.setValueField("id");
	    comboPersonas.setFieldLabel("Persona");
	    comboPersonas.setWidth(150);  
	    comboPersonas.setEnabled(true);
	    bottom.add(comboPersonas, new FormData("100%"));
	    
	    
	     //****************************** CARGAMOS EL PANEL CON LA ENTRADA DE ARTICULOS *****************//
	    
	    
	    final ContentPanel cpArticulos = new ContentPanel();
	    cpArticulos.setHeading("Selecciona los artículos que quieres solicitar");
	    cpArticulos.setLayout(new BorderLayout());  
	    cpArticulos.setCollapsible(true);
	    cpArticulos.setAutoHeight(true);
	    cpArticulos.setFrame(true);
	    cpArticulos.setExpanded(false);
	    cpArticulos.setStyleAttribute("paddingTop", "10px");
	    
	    
	   //***********************************************************************************************************************//
	    
	    final FormPanel frmArticulos = new FormPanel();
	    frmArticulos.setHeaderVisible(false);
	    frmArticulos.setAutoHeight(true);
	    frmArticulos.setLabelAlign(LabelAlign.TOP);
	    
		
	    final LayoutContainer subMain = new LayoutContainer();  
	    subMain.setLayout(new ColumnLayout());  
	    subMain.setStyleAttribute("paddingBottom", "15px");
	    subMain.setBorders(false);
	  
	    LayoutContainer subLeft = new LayoutContainer();  
	    subLeft.setStyleAttribute("paddingLeft", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.LEFT);  
	    subLeft.setLayout(layout);  
	    
	    LayoutContainer subRight = new LayoutContainer();
	    subRight.setStyleAttribute("paddingLeft", "100px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    subRight.setLayout(layout);  
	    
	    LayoutContainer subBottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    subBottom.setLayout(layout); 
	    
	    final TextField<String> articulo = new TextField<String>();
	    articulo.setFieldLabel("Articulo");
	    articulo.setValue("0016512-653-8569");
	    articulo.setEnabled(false);
	    articulo.addInputStyleName("noBorder");
	    subLeft.add(articulo, new FormData("100%"));
	    
	    final TextBox descArticulo = new TextBox();
	    descArticulo.setEnabled(false);
	    descArticulo.setValue("Descripción del tipo de artículo");
	    descArticulo.addStyleName("x-form-text");
	    subLeft.add(descArticulo, new FormData("100%")); 
   
	    final TextField<String> marca = new TextField<String>();  
	    marca.setFieldLabel("Marca");
	    marca.setEnabled(false);
	    subRight.add(marca, new FormData("100%"));	   
	  	
	    final TextField<String> txtExMin = new TextField<String>();  
	    txtExMin.setFieldLabel("Existencias mínimas");
	    subRight.add(txtExMin, new FormData("40%"));
	  
	    final TextField<String> txtExMax = new TextField<String>();
	    txtExMax.setFieldLabel("Existencias máximas");
	    subRight.add(txtExMax, new FormData("40%"));
	  
	    
	    final CheckBox seleccionar = new CheckBox();  
	    seleccionar.setFieldLabel("Seleccionar");
	    subLeft.addStyleName("check");
	    subLeft.add(seleccionar, new FormData("100%"));
	    	    
	    TextField<Integer> cantidad = new TextField<Integer>();  
	    cantidad.setFieldLabel("Cantidad");  
	    cantidad.setValue(0);
	    subRight.add(cantidad, new FormData("40%"));
	    
	    Label lblObs = new Label("Observaciones");
	    lblObs.addStyleName("etiqueta");
	    subBottom.add(lblObs, new FormData("100%"));
	    TextArea observaciones = new TextArea();
	    observaciones.setVisibleLines(4);
	    subBottom.add(observaciones, new FormData("100%"));
	    
	    final ButtonGroup btnGrp = new ButtonGroup(4);
	    final Button b1  = new Button();
		Button b2 = new Button(), b3 = new Button();
		final Button b4 = new Button();
	    b1.setText("Modificar Artículo");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				if(b1.getText().equalsIgnoreCase("Modificar Artículo")){
					b1.setText("Guardar Modificación");
					articulo.setEnabled(true);
					descArticulo.setEnabled(true);
					marca.setEnabled(true);
					b4.setVisible(true);
					subMain.recalculate();
					frmArticulos.layout(true);
					cpArticulos.layout(true);
				}
				else{
					b1.setText("Modificar Artículo");
					articulo.setEnabled(false);
					descArticulo.setEnabled(false);
					marca.setEnabled(false);
					b4.setVisible(false);
					subMain.recalculate();
					frmArticulos.layout(true);
					cpArticulos.layout(true);
				}
			}
	    });
	    b2.setText("Nuevo Artículo");
	    b2.setStyleAttribute("padding-right", "5px");
	    b2.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoNuevoArticulo nuevoArticulo = new DialogoNuevoArticulo(3);//nuevo articulo
				nuevoArticulo.show();
			}
	    	
	    });
	    b3.setText("Aceptar");
	    b3.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				cpArticulos.collapse();
			}
	    	
	    });
	    b4.setText("Cancelar Modificación");
	    b4.setVisible(false);
	    b4.setStyleAttribute("padding-right", "5px");
	    b4.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				b1.setText("Modificar Artículo");
				articulo.setEnabled(false);
				descArticulo.setEnabled(false);
				marca.setEnabled(false);
				b4.setVisible(false);
				subMain.recalculate();
				frmArticulos.layout(true);
				cpArticulos.layout(true);
			}
	    	
	    });
	    
	    btnGrp.add(b4);
	    btnGrp.add(b1);
	    btnGrp.add(b2);
	    btnGrp.add(b3);
	    btnGrp.setStyleAttribute("padding", "15px 0px");
	    btnGrp.setStyleAttribute("float", "right");
	    
	    
DataProxy proxy = null;
//	    RpcProxy<PagingLoadResult<ModelData>> proxy = new RpcProxy<PagingLoadResult<ModelData>>() {  
//	        @Override  
//	        public void load(Object loadConfig, AsyncCallback<PagingLoadResult<ModelData>> callback) {  
//	          service.getPosts((PagingLoadConfig) loadConfig, callback);  
//	        }  
//	      };  
//	    
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy , new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar pagingToolBar = new PagingToolBar(50); 
	    pagingToolBar.bind(loader);
	    pagingToolBar.setStyleName("paginacion");
	    
	    
	    subMain.add(subLeft, new ColumnData(.4));
	    subMain.add(subRight, new ColumnData(.6));
	    subMain.add(pagingToolBar, new ColumnData(.5));
	    subMain.add(btnGrp, new ColumnData(.5));
	    subMain.add(subBottom, new ColumnData(1));
	    
	    frmArticulos.add(subMain, new FormData("100%"));
	    
	    cpArticulos.add(frmArticulos, new BorderLayoutData(LayoutRegion.CENTER));
	      
	   
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("cantidad");  
	    column.setHeader("Cantidad");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(100);  
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
	    
	      
	    
	    ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setBorders(true);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button bt1  = new Button(), bt2 = new Button();
	    bt1.setText("Grabar");
	    bt1.setEnabled(false);
	    bt1.setStyleAttribute("padding-right", "5px");
	    bt2.setText("Deshacer");
	    bt2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("Atención", "Estas a punto de vaciar los datos ¿Estas seguro?", new Listener<MessageBoxEvent>() {

					@Override
					public void handleEvent(MessageBoxEvent be) {
						String button_id = be.getButtonClicked().getItemId();
						if (Dialog.YES == button_id) {
							comboPersonas.clear();
							comboUnidad.clear();
							comboSeccion.clear();
							fechaSolicitud.clear();
							fechaSolicitud.setValue(new Date());
							numSolicitud.clear();
							//aqui iria todo lo de articulos
							
						}
					}
				});
			}
	    	
	    });
	   
	    
	    gButtons.add(bt1);
	    gButtons.add(bt2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    bottom.add(cpArticulos,formData);
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Solicitud");
	    cp.setFrame(true);
	    cp.setVisible(false);
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	      
	    //cp.setVisible(false); //*********************** DE MOMENTO OCULTO *******************************//
	    
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));

	    main.add(cp, new ColumnData(1));
	    main.add(gButtons, new ColumnData(1));
	    
	    
	    frmNuevaSolicitud.add(main, new FormData("100%"));
		
	}

	public void loadFormAlbaranes(FormPanel frmAlbaranes) {
		
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmAlbaranes.setSize("100%", "100%");  
		frmAlbaranes.setBodyBorder(false);
		frmAlbaranes.setLabelAlign(LabelAlign.TOP);  
		frmAlbaranes.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
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
	    
	    
	    
	    DateTimeFormat dtFormat = DateTimeFormat.getFormat("dd-MM-yyyy");
	    DateField fechaSolicitud = new DateField();
	    fechaSolicitud.getPropertyEditor().setFormat(dtFormat);
	    fechaSolicitud.setFieldLabel("Fecha");
	    fechaSolicitud.setStyleAttribute("paddingBottom", "5px");
	    right.add(fechaSolicitud,new FormData("40%"));  
	    
	    TextField<String> numSolicitud = new TextField<String>();  
	    numSolicitud.setFieldLabel("Número de solicitud");
	    left.add(numSolicitud,new FormData("60%"));
	    
	    TextField<String> txtSeccion = new TextField<String>();  
	    txtSeccion.setFieldLabel("Número de solicitud");
	    bottom.add(txtSeccion,formData);
	    
	    TextField<String> txtDest = new TextField<String>();  
	    txtDest.setFieldLabel("Destinatario");
	    bottom.add(txtDest,formData);
	    
	    TextField<String> txtPerson = new TextField<String>();  
	    txtPerson.setFieldLabel("Persona");
	    bottom.add(txtPerson,formData);
	    
	    List<ColumnConfig> configs = new ArrayList<ColumnConfig>();  
	    
	    ColumnConfig column = new ColumnConfig();  
	    column.setId("solicitado");  
	    column.setHeader("Solicitado");  
	    column.setWidth(100);  
	    column.setRowHeader(true);  
	    configs.add(column);
	    
	    column = new ColumnConfig();  
	    column.setId("servido");  
	    column.setHeader("Servido");  
	    column.setWidth(100);  
	    configs.add(column);
	    
	    column = new ColumnConfig();  
	    column.setId("anulado");  
	    column.setHeader("Anulado");  
	    column.setWidth(100);  
	    configs.add(column); 
	    
	    column = new ColumnConfig();  
	    column.setId("devuelto");  
	    column.setHeader("Devuelto");  
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
	    column.setWidth(400); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("observaciones");  
	    column.setHeader("Observaciones");  
	    column.setWidth(200); 
	    configs.add(column);  
	    
	      
	    
	    ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setBorders(true);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setColumnLines(true);
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(false);  
	    cp.setHeaderVisible(false);
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("200px");
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	      
	    bottom.add(cp, formData);
	    
	    ButtonGroup gButtons = new ButtonGroup(2);
	    Button bt1  = new Button(), bt2 = new Button();
	    bt1.setText("Albarán Total");
	    bt1.setStyleAttribute("padding-right", "5px");
	    bt1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoAlbaranFecha dlgAlbaranF = new DialogoAlbaranFecha(1);
				dlgAlbaranF.show();
			}
	    	
	    });
	    

	    bt2.setText("Albarán por Artículos");
	    bt2.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoAlbaranFecha dlgAlbaranF = new DialogoAlbaranFecha(2);
				dlgAlbaranF.show();
			}
	    	
	    });
	    
	    
	    gButtons.add(bt1);
	    gButtons.add(bt2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    DataProxy proxy = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
	            proxy, new BeanModelReader());  
	        loader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(loader);
	    paginacion.setStyleName("paginacion");
	    
	    
	    main.add(left, new ColumnData(.4));
	    main.add(right, new ColumnData(.6));
	    main.add(bottom, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.5));
	    main.add(gButtons, new ColumnData(.5));
	    
	    
	    frmAlbaranes.add(main, new FormData("100%")); 
		
	}

	public void loadFormBajaArticulo(final FormPanel frmBajaArticulo) {
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmBajaArticulo.setSize("100%", "100%");  
		frmBajaArticulo.setBodyBorder(false);
		frmBajaArticulo.setLabelAlign(LabelAlign.TOP);  
		frmBajaArticulo.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
		    
		    final Label reales = new Label();
		    //reales.setText("Reales");

		    cpExistencias.add(lblReales, new RowData(-1, -1, new Margins(20)));
		    cpExistencias.add(reales, new RowData(-1, -1, new Margins(20,20,20,0)));
	    
	    ButtonGroup gButtons = new ButtonGroup(32);
	    Button b1  = new Button(), b2 = new Button();
	    b1.setText("Buscar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b1.addListener(Events.OnClick, new Listener<BaseEvent>(){

			@Override
			public void handleEvent(BaseEvent be) {
				DialogoNuevoArticulo dlgArticulo = new DialogoNuevoArticulo(1);//damos de baja
				dlgArticulo.show();
			}
	    	
	    });
	   
	    b2.setText("Deshacer");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				comboSeccion.clear();
				comboFamilia.clear();
				familias.removeAll();
				comboFamilia.setEnabled(false);
				subFamilia.removeAll();
				comboSubFamilia.clear();
				comboSubFamilia.setEnabled(false);
				codigoArt.clear();
				nombreArt.clear();
				marcaArt.clear();
				obsArt.clear();
				minimas.clear();
				idoneas.clear();
				reales.setText("");
			}
	    	
	    });
	    b2.setStyleAttribute("padding-right", "5px");

	   
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    bottom.add(cpExistencias,formData);
	    
    
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

	    main.add(gButtons, new ColumnData(1));
	    
	    frmBajaArticulo.add(main, new FormData("100%"));
	    frmBajaArticulo.recalculate();	
	}

}
