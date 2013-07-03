package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.patrimonio.plantillas.client.DTOs.ProveedoresDTO;
import com.patrimonio.plantillas.client.services.ProveedorService;
import com.patrimonio.plantillas.client.services.ProveedorServiceAsync;
import com.patrimonio.plantillas.client.widgets.Stock;
import com.patrimonio.plantillas.shared.RpcUtils;
import com.patrimonio.plantillas.shared.clases.Proveedores;

public class LoadMantenimientoUtils {

	ProveedorServiceAsync proService = GWT.create(ProveedorService.class);
	RpcUtils rpcUtils = new RpcUtils();
	long idProveedor;
	
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
	    
	    final TextField<String> nif = new TextField<String>();  
	    nif.setFieldLabel("N.I.F.");  
	    nif.setEnabled(false);
	    left.add(nif,formDataMid);	    
	    
	    final TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    nombre.setEnabled(false);
	    right.add(nombre,formData);	    
	    
	    final TextField<String> actividad = new TextField<String>();  
	    actividad.setFieldLabel("Actividad");  
	    actividad.setEnabled(false);
	    left.add(actividad,formData);	    
	    
	    final TextField<String> contacto = new TextField<String>();  
	    contacto.setFieldLabel("Contacto");  
	    contacto.setEnabled(false);
	    right.add(contacto,formData);	    
	    
	    final TextField<String> domicilio = new TextField<String>();  
	    domicilio.setFieldLabel("Domicilio");  
	    domicilio.setEnabled(false);
	    left.add(domicilio,formData);	    
	    
	    final TextField<String> poblacion = new TextField<String>();  
	    poblacion.setFieldLabel("Población"); 
	    poblacion.setEnabled(false);
	    right.add(poblacion,formData);	    
	    
	    final TextField<String> cp = new TextField<String>();  
	    cp.setFieldLabel("Código Postal"); 
	    cp.setEnabled(false);
	    left.add(cp,formDataMid);	    
	    
	    final TextField<String> provincia = new TextField<String>();  
	    provincia.setFieldLabel("Provincia");  
	    provincia.setEnabled(false);
	    right.add(provincia,formData);	    
	    
	    final TextField<String> tfno = new TextField<String>();  
	    tfno.setFieldLabel("Teléfono");  
	    tfno.setEnabled(false);
	    left.add(tfno,formDataMid);	    
	    
	    final TextField<String> fax = new TextField<String>();  
	    fax.setFieldLabel("Fax");  
	    fax.setEnabled(false);
	    right.add(fax,formDataMid);	    
	    
	    final TextField<String> tfno2 = new TextField<String>();  
	    tfno2.setFieldLabel("Teléfono 2"); 
	    tfno2.setEnabled(false);
	    left.add(tfno2,formDataMid);	    
	    
	    final TextField<String> movil = new TextField<String>();  
	    movil.setFieldLabel("Teléfono Móvil");
	    movil.setEnabled(false);
	    right.add(movil,formDataMid);	
	    
	    final CheckBox estado = new CheckBox();  
	    estado.addStyleName("margenTop");
	    estado.setFieldLabel("Activo");
	    estado.setEnabled(false);
	    right.addStyleName("check");
	    right.add(estado, formData);
	    
	    final TextField<String> correo = new TextField<String>();  
	    correo.setFieldLabel("Correo electrónico");  
	    correo.setEnabled(false);
	    bottom.add(correo,new FormData("100%"));	
	    
	    
	    RpcProxy<PagingLoadResult<Proveedores>> proxy = new RpcProxy<PagingLoadResult<Proveedores>>() {
			@Override
			public void load(Object loadConfig,
					AsyncCallback<PagingLoadResult<Proveedores>> callback) {
				proService.findAll((PagingLoadConfig) loadConfig,callback);
			}
		};

		// loader
		final PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);

	    final PagingToolBar paginacion = new PagingToolBar(rpcUtils.countAll()); 
	    paginacion.bind(loader);
	    paginacion.setStyleName("paginacion");
	    
	    ButtonGroup gButtons = new ButtonGroup(4);
	    final Button b1  = new Button();
	    final Button b2 = new Button();
	    final Button b3 = new Button();
	    final Button b4 = new Button();
	    b1.setText("Agregar");
	    b1.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(b1.getText().equalsIgnoreCase("Agregar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilitaTodo(true);
				}
				else{
					Log.debug("Estamos en el caso de guardar y vamos a llamar a la funcion en rpcUtils");
					rpcUtils.checkValuesAndSaveProveedor(nif.getValue(),nombre.getValue(),actividad.getValue(),contacto.getValue(),domicilio.getValue(),poblacion.getValue(),
							Integer.parseInt(cp.getValue()),provincia.getValue(),tfno.getValue(),tfno2.getValue(),fax.getValue(),Integer.parseInt(movil.getValue()),correo.getValue(), estado.getValue());
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				nif.setEnabled(que);
				nombre.setEnabled(que);
				actividad.setEnabled(que);
				contacto.setEnabled(que);
				domicilio.setEnabled(que);
				poblacion.setEnabled(que);
				cp.setEnabled(que);
				provincia.setEnabled(que);
				tfno.setEnabled(que);
				tfno2.setEnabled(que);
				fax.setEnabled(que);
				movil.setEnabled(que);
				correo.setEnabled(que);
				estado.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				rpcUtils.deleteProveedor(idProveedor);
				
			}
	    	
	    });
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	   
	    
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
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    configs.add(column);  
      
	    
	    ListStore<Stock> store = new ListStore<Stock>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<Stock> grid = new Grid<Stock>(store,cm);
	    grid.setAutoExpandColumn("nombre");  
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    
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
		FormData frmData = new FormData("40%");
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		frmData.setMargins(m);
		
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
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(300);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(400);  
	    configs.add(column);  
	  
  
	      
	    
	    ListStore<Stock> store = new ListStore<Stock>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<Stock> grid = new Grid<Stock>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Subfamilias");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
	    cp.setHeight("300px");
	    
	    cp.setStyleAttribute("paddingTop", "10px");
	    	    
	    cp.add(grid);
	    
	    DataProxy entregasPRx = null; 
		final BasePagingLoader<PagingLoadResult<ModelData>> entregasLoader = new BasePagingLoader<PagingLoadResult<ModelData>>(  
				entregasPRx, new BeanModelReader());  
	        //entregasLoader.setRemoteSort(true);
	        entregasLoader.setRemoteSort(false);
	        entregasLoader.setSortField("id");
	        entregasLoader.setSortDir(SortDir.ASC);
	    
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
	    
	    center.add(codigo, frmData);
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
	    column.setId("codigo");  
	    column.setHeader("Código");  
	    column.setWidth(200);  
	    column.setRowHeader(true);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("nombre");  
	    column.setHeader("Nombre");  
	    column.setWidth(400);  
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("cantidad");  
	    column.setHeader("Cantidad");  
	    column.setWidth(100); 
	    configs.add(column);  
	  
	    column = new ColumnConfig();  
	    column.setId("anualidad");  
	    column.setHeader("Anualidad");  
	    column.setWidth(100); 
	    configs.add(column);  
	    
	      
	    
	    ListStore<Stock> store = new ListStore<Stock>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<Stock> grid = new Grid<Stock>(store,cm);
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    
	    
	    ContentPanel cp = new ContentPanel();  
	    cp.setBodyBorder(true);  
	    cp.setHeading("Artículos del puesto de trabajo");
	    cp.setButtonAlign(HorizontalAlignment.CENTER);  
	    cp.setLayout(new FitLayout());
	    cp.setFrame(true);
	    cp.setHeight("300px");
	    
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
