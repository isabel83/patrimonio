package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
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
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.client.widgets.Stock;

public class LoadMantenimientoUtils {

	public void loadFormProveedores(FormPanel frmProveedores) {
		FormData formDataMid = new FormData("50%");
		FormData formData = new FormData("90%");
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		formDataMid.setMargins(m);
		
		frmProveedores.setSize("100%", "100%");  
		frmProveedores.setBodyBorder(false);
		frmProveedores.setLabelAlign(LabelAlign.TOP);  
		frmProveedores.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setStyleAttribute("paddingRight", "10px");
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setLayout(layout); 
	    
	    
	    TextField<String> nif = new TextField<String>();  
	    nif.setFieldLabel("N.I.F.");  
	    left.add(nif,formDataMid);	    
	    
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    right.add(nombre,formData);	    
	    
	    TextField<String> actividad = new TextField<String>();  
	    actividad.setFieldLabel("Actividad");  
	    left.add(actividad,formData);	    
	    
	    TextField<String> contacto = new TextField<String>();  
	    contacto.setFieldLabel("Contacto");  
	    right.add(contacto,formData);	    
	    
	    TextField<String> domicilio = new TextField<String>();  
	    domicilio.setFieldLabel("Domicilio");  
	    left.add(domicilio,formData);	    
	    
	    TextField<String> poblacion = new TextField<String>();  
	    poblacion.setFieldLabel("Población");  
	    right.add(poblacion,formData);	    
	    
	    TextField<String> cp = new TextField<String>();  
	    cp.setFieldLabel("Código Postal");  
	    left.add(cp,formDataMid);	    
	    
	    TextField<String> provincia = new TextField<String>();  
	    provincia.setFieldLabel("Provincia");  
	    right.add(provincia,formData);	    
	    
	    TextField<String> tfno = new TextField<String>();  
	    tfno.setFieldLabel("Teléfono");  
	    left.add(tfno,formDataMid);	    
	    
	    TextField<String> fax = new TextField<String>();  
	    fax.setFieldLabel("Fax");  
	    right.add(fax,formDataMid);	    
	    
	    TextField<String> tfno2 = new TextField<String>();  
	    tfno2.setFieldLabel("Teléfono 2");  
	    left.add(tfno2,formDataMid);	    
	    
	    TextField<String> movil = new TextField<String>();  
	    movil.setFieldLabel("Teléfono Móvil");  
	    right.add(movil,formDataMid);	    
	    
	    TextField<String> correo = new TextField<String>();  
	    correo.setFieldLabel("Correo electrónico");  
	    bottom.add(correo,new FormData("100%"));	
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
	    main.add(bottom, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    frmProveedores.add(main, new FormData("100%"));
	}

	public void loadFormDestinatarios(FormPanel frmDestinatarios) {
		FormData formData = new FormData("50%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmDestinatarios.setSize("100%", "100%");  
		frmDestinatarios.setBodyBorder(false);
		frmDestinatarios.setLabelAlign(LabelAlign.TOP);  
		frmDestinatarios.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "35px");
	    main.setStyleAttribute("paddingTop", "35px");
	    main.setBorders(false);
	  
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingLeft", "10px");
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    left.setLayout(layout);  
	    
	    LayoutContainer right = new LayoutContainer();
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	    
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    left.add(nombre,formData);	
	    
	    CheckBox tienePuesto = new CheckBox();  
	    tienePuesto.addStyleName("margenTop");
	    tienePuesto.setFieldLabel("¿Tiene puestos de trabajo que dependen de esta unidad para la entrega de vestuario?(Si/No)");
	    right.addStyleName("check");
	    right.add(tienePuesto, formData);
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	    
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    frmDestinatarios.add(main, new FormData("100%"));
	}

	public void loadFormSecciones(FormPanel frmSecciones) {
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmSecciones.setSize("100%", "100%");  
		frmSecciones.setBodyBorder(false);
		frmSecciones.setLabelAlign(LabelAlign.TOP);  
		frmSecciones.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    LayoutContainer center = new LayoutContainer();
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	  
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    
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
	    cp.setHeading("Familias");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("300px");
	    cp.setFrame(true);
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    center.add(nombre, formData);
	    center.add(cp, formData);
	    
	    main.add(center, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    frmSecciones.add(main, new FormData("100%"));
	}

	public void loadFormFamilias(FormPanel frmFamilias) {
		FormData formData = new FormData("100%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmFamilias.setSize("100%", "100%");  
		frmFamilias.setBodyBorder(false);
		frmFamilias.setLabelAlign(LabelAlign.TOP);  
		frmFamilias.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	    
	    LayoutContainer center = new LayoutContainer();
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	    TextField<String> codigo = new TextField<String>();  
	    codigo.setFieldLabel("Código"); 
	    
	    Label lblSeccion = new Label("Sección:");
	    lblSeccion.setStyleName("etiqueta margen");
	    ListBox lstSeccion = new ListBox();
	    lstSeccion.setVisibleItemCount(1);
	    lstSeccion.addItem("...");
	  
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    
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
	    cp.setHeading("Subfamilias");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("300px");
	    cp.setFrame(true);
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    center.add(codigo, new FormData("40%"));
	    center.add(lblSeccion, formData);
	    center.add(lstSeccion, formData);
	    center.add(nombre, formData);
	    center.add(cp, formData);
	    
	    main.add(center, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    frmFamilias.add(main, new FormData("100%"));
	}

	public void loadFormSubFamilias(FormPanel frmSubFamilias) {
		FormData formData = new FormData("100%");
		Margins m = new Margins(5);
	
		formData.setMargins(m);
		
		frmSubFamilias.setSize("100%", "100%");  
		frmSubFamilias.setBodyBorder(false);
		frmSubFamilias.setLabelAlign(LabelAlign.TOP);  
		frmSubFamilias.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
	    LayoutContainer main = new LayoutContainer();  
	    main.setLayout(new ColumnLayout());  
	    main.setStyleAttribute("paddingBottom", "15px");
	    main.setBorders(false);
	  
	
	    LayoutContainer center = new LayoutContainer();
	    FormLayout layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    center.setLayout(layout);  
	    
	    TextField<String> codigo = new TextField<String>();  
	    codigo.setFieldLabel("Código"); 
	    
	    Label lblFamilia = new Label("Familia:");
	    lblFamilia.setStyleName("etiqueta");
	    ListBox lstFamilia = new ListBox();
	    lstFamilia.setVisibleItemCount(1);
	    lstFamilia.addItem("...");
	  
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	     
	    
	    
	    center.add(lblFamilia, formData);
	    center.add(lstFamilia, formData);
	    center.add(codigo, formData);
	    center.add(nombre, formData);
	    
	    main.add(center, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    
	    frmSubFamilias.add(main, new FormData("100%"));
	}

	public void loadFormPuestos(FormPanel frmPuestos) {
		FormData formData = new FormData("40%"); 
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		
		frmPuestos.setSize("100%", "100%");  
		frmPuestos.setBodyBorder(false);
		frmPuestos.setLabelAlign(LabelAlign.TOP);  
		frmPuestos.setButtonAlign(HorizontalAlignment.CENTER);  
	   
	  
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
	    right.setStyleAttribute("paddingRight", "10px");
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    right.setLayout(layout);  
	    
	      
	    LayoutContainer bottom = new LayoutContainer();  
	    layout = new FormLayout();  
	    layout.setLabelAlign(LabelAlign.TOP);  
	    bottom.setLayout(layout); 
	    bottom.setStyleAttribute("paddingLeft", "10px");
	    bottom.setStyleAttribute("paddingRight", "10px");
	    
	    
	    Label lblDelegacion = new Label("Delegación / Destinatario:");
	    lblDelegacion.setStyleName("etiqueta");
	    ListBox lstColectivo = new ListBox();
	    lstColectivo.setVisibleItemCount(1);
	    lstColectivo.addItem("...");
	    left.add(lblDelegacion, formData);
	    left.add(lstColectivo, formData);
	  
	    TextField<String> grupo = new TextField<String>();  
	    grupo.setFieldLabel("Grupo profesional / Colectivo");
	    grupo.setLabelStyle("float: initial");
	    right.add(grupo, formData);
	    
	    TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre Trabajador");
	    nombre.setLabelStyle("margin-top: 5px");
	    left.add(nombre, formData);
	    
	    CheckBox activo = new CheckBox();  
	    activo.setFieldLabel("Activo");
	    right.addStyleName("check");
	    right.add(activo, formData);
	    
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
	    cp.setHeading("Artículos del puesto de trabajo");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setHeight("300px");
	    cp.setFrame(true);
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	    bottom.add(cp, new FormData("100%"));
	    
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        entregasLoader.setRemoteSort(true); 
	    
	    final PagingToolBar paginacion = new PagingToolBar(50); 
	    paginacion.bind(entregasLoader);
	    paginacion.setStyleName("paginacion");
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    Button b1  = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button();
	    b1.setText("Agregar");
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Buscar nombre");
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar delegación");
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.setBodyBorder(false);
	    gButtons.setBorders(false);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
	    main.add(bottom, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    frmPuestos.add(main, new FormData("100%"));
	}

}
