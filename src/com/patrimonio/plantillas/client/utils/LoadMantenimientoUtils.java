package com.patrimonio.plantillas.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.BeanModelReader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.patrimonio.plantillas.client.widgets.dialogs.DialogoBuscar;
import com.patrimonio.plantillas.shared.RpcUtilsDestinatarios;
import com.patrimonio.plantillas.shared.RpcUtilsFamilias;
import com.patrimonio.plantillas.shared.RpcUtilsPersonas;
import com.patrimonio.plantillas.shared.RpcUtilsProveedores;
import com.patrimonio.plantillas.shared.RpcUtilsSecciones;
import com.patrimonio.plantillas.shared.RpcUtilsSubfamilias;
import com.patrimonio.plantillas.shared.clases.Destinatarios;
import com.patrimonio.plantillas.shared.clases.Familias;
import com.patrimonio.plantillas.shared.clases.Proveedores;
import com.patrimonio.plantillas.shared.clases.Secciones;
import com.patrimonio.plantillas.shared.clases.Subfamilias;

public class LoadMantenimientoUtils {

	RpcUtilsProveedores provUtils = new RpcUtilsProveedores();
	RpcUtilsDestinatarios destiUtils = new RpcUtilsDestinatarios();
	RpcUtilsSecciones secUtils = new RpcUtilsSecciones();
	RpcUtilsFamilias famiUtils = new RpcUtilsFamilias();
	RpcUtilsSubfamilias subUtils = new RpcUtilsSubfamilias();
	RpcUtilsPersonas persUtils = new RpcUtilsPersonas();
	
	protected long idProveedor;
	protected long idDestinatario;
	protected long idSeccion;
	protected long idFamilia;
	protected long idSubfamilia;
	protected Destinatarios destinatario = new Destinatarios();
	protected Proveedores proveedor = new Proveedores();
	protected Secciones seccion = new Secciones();
	protected Familias familia = new Familias();
	protected Subfamilias subfamilia = new Subfamilias();
	
	
	
	public void loadFormProveedores(FormPanel frmProveedores) {
		
		List<Proveedores> todos = provUtils.cargaGolbal();
		
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
	    	   
	    
	    final TextField<String> correo = new TextField<String>();  
	    correo.setFieldLabel("Correo electrónico");  
	    correo.setEnabled(false);
	    left.add(correo,formData);	
	    
	    final CheckBox estado = new CheckBox();  
	    estado.setFieldLabel("Activo");
	    estado.setEnabled(false);
	    right.add(estado, new FormData("10%"));
	    
	    
	    RpcProxy<PagingLoadResult<Proveedores>> proxy = new RpcProxy<PagingLoadResult<Proveedores>>() {

			@Override
			protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<Proveedores>> callback) {
				provUtils.cargaGolbal();
			}
		};

		// loader
		final PagingLoader<PagingLoadResult<ModelData>> loader = new BasePagingLoader<PagingLoadResult<ModelData>>(proxy);

	    final PagingToolBar paginacion = new PagingToolBar(1); 
	    paginacion.bind(loader);
	    loader.load();
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
					//Log.debug("Estamos en el caso de guardar y vamos a llamar a la funcion en provUtils");
					provUtils.checkValuesAndSaveProveedor(nif.getValue(),nombre.getValue(),actividad.getValue(),contacto.getValue(),domicilio.getValue(),poblacion.getValue(),
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
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita(true);
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}
			
			private void atras() {
				nif.setValue(proveedor.getNif());
				nombre.setValue(proveedor.getNombre());
				actividad.setValue(proveedor.getActividad());
				contacto.setValue(proveedor.getContacto());
				domicilio.setValue(proveedor.getDomicilio());
				poblacion.setValue(proveedor.getPoblacion());
				cp.setValue(String.valueOf(proveedor.getCp()));
				provincia.setValue(proveedor.getProvincia());
				tfno.setValue(proveedor.getTlf1());
				tfno2.setValue(proveedor.getTlf2());
				fax.setValue(proveedor.getFax());
				movil.setValue(String.valueOf(proveedor.getMovil()));
				correo.setValue(proveedor.getEmail());
				if(proveedor.getId_estado()==1)
				estado.setValue(true);
				else estado.setValue(false);
				
				
				habilita(false);
			}

			private void habilita(boolean que) {
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
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				provUtils.deleteProveedor(idProveedor);
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				DialogoBuscar busqueda = new DialogoBuscar();
				busqueda.show();
			}
	    	
	    });
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    
	    
	    main.add(left, new ColumnData(.5));
	    main.add(right, new ColumnData(.5));
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
	    
	    
	    final TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre"); 
	    nombre.setAutoValidate(true);
	    nombre.setEnabled(false);
	    left.add(nombre,formData);	
	    
	    final CheckBox tienePuesto = new CheckBox();  
	    tienePuesto.addStyleName("margenTop");
	    tienePuesto.setEnabled(false);
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
					destiUtils.checkValuesAndSaveDestinatario(nombre.getValue(), tienePuesto.getValue());
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				nombre.setEnabled(que);
				tienePuesto.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita();
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}

			private void habilita() {
				nombre.setEnabled(true);
				tienePuesto.setEnabled(true);
				
			}

			private void atras() {
				nombre.setValue(destinatario.getDescripcion());
				nombre.setEnabled(false);
				tienePuesto.setValue(false);
				tienePuesto.setEnabled(false);
			}
	    	
	    });
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				destiUtils.deleteDestinatario(idDestinatario);
				
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				DialogoBuscar busqueda = new DialogoBuscar();
				busqueda.show();
				
			}
	    	
	    });
	    
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
	    
	  
	    final TextField<String> nombre = new TextField<String>();   
	    nombre.setFieldLabel("Nombre");  
	    nombre.setEnabled(false);
	    
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
      
	    
	    ListStore<BaseModel> store = new ListStore<BaseModel>();
	  //  store.add(getStocks()); //(REVISAR ESTO PORQUE DA ERROR EN LA DEMO)
	    
	    ColumnModel cm = new ColumnModel(configs);  
	  
	    Grid<BaseModel> grid = new Grid<BaseModel>(store,cm);
	    grid.setAutoExpandColumn("nombre");  
	    grid.setBorders(false);  
	    grid.setStripeRows(true);  
	    grid.setColumnLines(true);  
	    grid.setColumnReordering(true);  
	    grid.setEnabled(false); //no es editable desde aqui con lo cual solo mostramos los datos
	    
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
					//Log.debug("Estamos en el caso de guardar y vamos a llamar a la funcion en secciones");
					secUtils.checkValuesAndSaveSecciones(nombre.getValue());
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				nombre.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita();
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}

			private void habilita() {
				nombre.setEnabled(true);
				
			}

			private void atras() {
				nombre.setValue(seccion.getDescripcion());
				nombre.setEnabled(false);
			}
	    });
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				secUtils.deleteSeccion(idSeccion);
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				DialogoBuscar busqueda = new DialogoBuscar();
				busqueda.show();
			}
	    	
	    });
	    
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
	    
	    
	    
	    final TextField<String> codigo = new TextField<String>();  
	    codigo.setFieldLabel("Código");
	    codigo.setEnabled(false);
	    
	    ListStore<BaseModel> secciones = new ListStore<BaseModel>();  
	    secUtils.loadSeccionesCombo(secciones);
	  
	    final ComboBox<BaseModel> combo = new ComboBox<BaseModel>();  
	    combo.setEmptyText("Selecciona una sección");  
	    combo.setStore(secciones);  
	    combo.setDisplayField("nombre");  
	    combo.setValueField("id");
	    combo.setFieldLabel("Sección");
	    combo.setWidth(150);  
	    combo.setEnabled(false);
	    combo.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//Log.debug("El id seleccionado es: " + se.getSelectedItem().get("id"));
				idSeccion = se.getSelectedItem().get("id");
			}
	    	
	    });
	  
	    final TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre"); 
	    nombre.setEnabled(false);
	    
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
					//Log.debug("Estamos en el caso de guardar y vamos a llamar a la funcion en familias");
					famiUtils.checkValuesAndSaveFamilia(nombre.getValue(), codigo.getValue(), (int)idSeccion );
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				nombre.setEnabled(que);
				codigo.setEnabled(que);
				combo.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){
	    	@Override
			public void componentSelected(ButtonEvent ce) {
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita(true);
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}
			
			private void atras() {
				//recargamos los datos anteriores
				nombre.setValue(familia.getDescripcion());
				nombre.setEnabled(false);
				codigo.setValue(familia.getCodigo());
				codigo.setEnabled(false);
				combo.select(familia); //repasar esto
				combo.setEnabled(false);
			}

			private void habilita(boolean que) {
				nombre.setEnabled(que);
				codigo.setEnabled(que);
				combo.setEnabled(que);
				
			}

	    });
	    
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				famiUtils.deleteFamilia(idFamilia);
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				DialogoBuscar busqueda = new DialogoBuscar();
				busqueda.show();
			}
	    	
	    });
	    
	    gButtons.add(b1);
	    gButtons.add(b2);
	    gButtons.add(b3);
	    gButtons.add(b4);
	    gButtons.addStyleName("botonesFuncionales");
	    
	    center.add(codigo, frmData);
	    center.add(combo, formData);
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
	    
	    final TextField<String> codigo = new TextField<String>();  
	    codigo.setFieldLabel("Código"); 
	    codigo.setEnabled(false);
	    
	    ListStore<BaseModel> familias = new ListStore<BaseModel>();  
	    famiUtils.loadFamiliasCombo(familias);
	  
	    final ComboBox<BaseModel> combo = new ComboBox<BaseModel>();  
	    combo.setEmptyText("Selecciona una familia");  
	    combo.setStore(familias);  
	    combo.setDisplayField("nombre");  
	    combo.setValueField("id");
	    combo.setFieldLabel("Familia");
	    combo.setWidth(150);  
	    combo.setEnabled(false);
	    combo.addSelectionChangedListener(new SelectionChangedListener<BaseModel>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//Log.debug("El id seleccionado es: " + se.getSelectedItem().get("nombre"));
				familia = se.getSelectedItem().get("id");
			}
	    	
	    });
	  
	    final TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre");  
	    nombre.setEnabled(false);
	    
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
				//	Log.debug("El valor del combo es: " + familia);
					subUtils.checkValuesAndSaveSubFamilia(nombre.getValue(), codigo.getValue(), (int)idFamilia );
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				nombre.setEnabled(que);
				codigo.setEnabled(que);
				combo.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){
	    	@Override
			public void componentSelected(ButtonEvent ce) {
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita(true);
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}
			
			private void atras() {
				//recargamos los datos anteriores
				nombre.setValue(familia.getDescripcion());
				nombre.setEnabled(false);
				codigo.setValue(familia.getCodigo());
				codigo.setEnabled(false);
				combo.select(familia); //repasar esto
				combo.setEnabled(false);
			}

			private void habilita(boolean que) {
				nombre.setEnabled(que);
				codigo.setEnabled(que);
				combo.setEnabled(que);
				
			}
	    	
	    });
	    b2.setStyleAttribute("padding-right", "5px");
	    b3.setText("Eliminar");
	    b3.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				subUtils.deleteSubfamilia(idSubfamilia);
				
			}
	    	
	    });
	    b3.setStyleAttribute("padding-right", "5px");
	    b4.setText("Buscar");
	    b4.addSelectionListener(new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				DialogoBuscar busqueda = new DialogoBuscar();
				busqueda.show();
			}
	    	
	    });
	    
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
	     
	    
	    
	    
	    center.add(combo, formData);
	    center.add(codigo, formData);
	    center.add(nombre, formData);
	    
	    main.add(center, new ColumnData(1));
	    main.add(paginacion, new ColumnData(.6));
	    main.add(gButtons, new ColumnData(.4));
	    
	    
	    frmSubFamilias.add(main, new FormData("100%"));
	}

	public void loadFormPuestos(FormPanel frmPuestos) {
		FormData formData = new FormData("90%"); 
		FormData formDataMid = new FormData("40%");
		Margins m = new Margins();
		m.top = 5;
		m.left=5;
		m.right=5;
		formData.setMargins(m);
		formDataMid.setMargins(m);
		
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
	    
	    
	    ListStore<BaseModel> unidades = new ListStore<BaseModel>();  
	    destiUtils.loadUnidadCombo(unidades);
	  
	    final ComboBox<BaseModel> comboUnidad = new ComboBox<BaseModel>();  
	    comboUnidad.setEmptyText("Selecciona una delegación / destinatario");  
	    comboUnidad.setStore(unidades);  
	    comboUnidad.setDisplayField("nombre");  
	    comboUnidad.setValueField("id");
	    comboUnidad.setFieldLabel("Delegación / Destinatario");
	    comboUnidad.setWidth(150);  
	    comboUnidad.setEnabled(true);
	    left.add(comboUnidad, formData);
	  
	    final TextField<String> grupo = new TextField<String>();  
	    grupo.setFieldLabel("Grupo profesional / Colectivo");
	    grupo.setLabelStyle("float: initial");
	    right.add(grupo, formData);
	    
	    final TextField<String> nombre = new TextField<String>();  
	    nombre.setFieldLabel("Nombre Trabajador");
	    nombre.setLabelStyle("margin-top: 5px");
	    left.add(nombre, formData);
	    
	    final CheckBox activo = new CheckBox();  
	    activo.setFieldLabel("Activo");
	    right.addStyleName("check");
	    right.add(activo, formDataMid);
	    
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
					//persUtils.checkValuesAndSavePuesto(nombre.getValue(),1);
					
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
					habilitaTodo(false);
				}
				
			}

			public void habilitaTodo(boolean que) {
				comboUnidad.setEnabled(que);
				nombre.setEnabled(que);
				grupo.setEnabled(que);
				activo.setEnabled(que);
			}
		
	    });
	    
	    b1.setStyleAttribute("padding-right", "5px");
	    b2.setText("Modificar");
	    b2.addSelectionListener(new SelectionListener<ButtonEvent>(){
	    	@Override
			public void componentSelected(ButtonEvent ce) {
				if(b2.getText().equalsIgnoreCase("Modificar")){
					b1.setText("Guardar");
					b2.setText("Deshacer");
					b3.setVisible(false);
					b4.setVisible(false);
					habilita(true);
				}
				else{
					atras();
					b1.setText("Agregar");
					b2.setText("Modificar");
					b3.setVisible(true);
					b4.setVisible(true);
				}
				
			}
			
			private void atras() {
				//recargamos los datos anteriores
				habilita(false);
			}

			private void habilita(boolean que) {
				nombre.setEnabled(que);
				comboUnidad.setEnabled(que);
				grupo.setEnabled(que);
				activo.setEnabled(que);
				
			}
	    	
	    });
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

